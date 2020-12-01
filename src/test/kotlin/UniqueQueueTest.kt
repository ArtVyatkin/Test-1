import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

internal class UniqueQueueTest {

    @Test
    fun add_simpleAdding() {
        val uniqueQueue = UniqueQueue<Int>(2)
        uniqueQueue.add(12)
        assertIterableEquals(listOf(12), uniqueQueue)
    }

    @Test
    fun add_existingElement_ThrowsException() {
        val uniqueQueue = UniqueQueue<Int>(2)
        uniqueQueue.add(12)
        assertThrows(IllegalArgumentException::class.java) {
            uniqueQueue.add(12)
        }
    }

    @Test
    fun add_oversizeAdding_ThrowsException() {
        val uniqueQueue = UniqueQueue<Double>(3)
        uniqueQueue.add(1.0)
        uniqueQueue.add(-9.0)
        uniqueQueue.add(3.9)
        assertThrows(IllegalStateException::class.java) {
            uniqueQueue.add(8.8)
        }
    }

    @Test
    fun add_manyElements() {
        val uniqueQueue = UniqueQueue<String>(5)
        uniqueQueue.add("!")
        uniqueQueue.add("%")
        uniqueQueue.add("$")
        uniqueQueue.add("&")

        assertIterableEquals(listOf("!", "%", "$", "&"), uniqueQueue)
    }

    @Test
    fun clear() {
        val uniqueQueue = UniqueQueue<String>(5)
        uniqueQueue.add("!")
        uniqueQueue.add("%")
        uniqueQueue.add("$")
        uniqueQueue.add("&")
        uniqueQueue.clear()

        assertIterableEquals(listOf<Int>(), uniqueQueue)
    }

    @Test
    fun remove_simpleRemoving() {
        val uniqueQueue = UniqueQueue<Int>(5)
        uniqueQueue.add(12)
        uniqueQueue.add(50)
        uniqueQueue.add(20)
        uniqueQueue.remove()
        assertIterableEquals(listOf(50, 20), uniqueQueue)
    }

    @Test
    fun remove_emptyQueue_ThrowsException() {
        val uniqueQueue = UniqueQueue<Int>(5)
        assertThrows(NoSuchElementException::class.java) {
            uniqueQueue.remove()
        }
    }

    @Test
    fun contains_containsElement() {
        val uniqueQueue = UniqueQueue<Int>(5)
        uniqueQueue.add(12)
        uniqueQueue.add(50)
        uniqueQueue.add(20)
        uniqueQueue.remove()
        assertTrue(uniqueQueue.contains(50))
    }

    @Test
    fun isEmpty_SimpleQueue_MustWork() {
        val queue = UniqueQueue<Int>(42)
        repeat(21) {
            queue.add(it)
        }
        assertFalse(queue.isEmpty())
    }

    @Test
    fun isEmpty_EmptyQueue_MustWork() {
        val queue = UniqueQueue<Int>(42)
        assert(queue.isEmpty())
    }

    @Test
    fun isEmpty_AddAndRemove_MustWork() {
        val queue = UniqueQueue<Int>(42)
        queue.add(0)
        queue.remove(0)
        assert(queue.isEmpty())
    }

    @Test
    fun poll() {
        val uniqueQueue = UniqueQueue<Int>(5)
        uniqueQueue.add(12)
        uniqueQueue.add(70)
        uniqueQueue.add(20)
        uniqueQueue.poll()
        assertIterableEquals(listOf(70, 20), uniqueQueue)
    }

    @Test
    fun poll_checkReturns() {
        val uniqueQueue = UniqueQueue<Int>(5)
        uniqueQueue.add(12)
        uniqueQueue.add(70)
        uniqueQueue.add(20)
        assertEquals(12, uniqueQueue.poll())
    }

    @Test
    fun poll_isEmpty() {
        val uniqueQueue = UniqueQueue<Int>(5)
        assertEquals(null, uniqueQueue.poll())
    }

    @Test
    fun peek() {
        val uniqueQueue = UniqueQueue<Int>(6)
        uniqueQueue.add(3)
        uniqueQueue.add(70)
        uniqueQueue.add(20)
        assertEquals(3, uniqueQueue.peek())
    }
}
