import java.lang.IllegalStateException
import java.util.Queue
import java.util.LinkedList

class UniqueQueue<T>(override val size: Int) : Queue<T> {
    private val linkedList = LinkedList<T>()

    override fun add(element: T): Boolean {
        when {
            linkedList.size == size -> throw IllegalStateException("The unique queue is full")
            linkedList.contains(element) -> throw IllegalArgumentException("The element already exists")
        }
        return linkedList.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        if (elements.isEmpty()) return false
        val elementsAsSet = elements.toSet()
        if (elementsAsSet.size + linkedList.size > size) {
            throw IllegalStateException("The unique queue will overflow")
        }
        elementsAsSet.forEach {
            if (linkedList.contains(it)) {
                throw IllegalArgumentException("One of the elements already exists")
            }
        }
        return linkedList.addAll(elementsAsSet)
    }

    override fun clear() = linkedList.clear()

    override fun iterator(): MutableIterator<T> = linkedList.iterator()

    override fun remove(): T = linkedList.remove()

    override fun contains(element: T) = linkedList.contains(element)

    override fun containsAll(elements: Collection<T>) = linkedList.containsAll(elements)

    override fun isEmpty() = linkedList.isEmpty()

    override fun remove(element: T) = linkedList.remove(element)

    override fun removeAll(elements: Collection<T>) = linkedList.removeAll(elements)

    override fun retainAll(elements: Collection<T>) = linkedList.retainAll(elements)

    override fun offer(e: T): Boolean {
        if (linkedList.contains(e)) {
            throw IllegalArgumentException("The element already exists")
        }
        return if (linkedList.size == size) {
            false
        } else {
            linkedList.offer(e)
        }
    }

    override fun poll(): T? = if (linkedList.isEmpty()) {
        null
    } else {
        linkedList.poll()
    }

    override fun element(): T = linkedList.element()

    override fun peek(): T? = linkedList.peek()
}
