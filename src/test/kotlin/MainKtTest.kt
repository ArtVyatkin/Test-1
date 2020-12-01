import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals

internal class MainKtTest {

    @Test
    fun sum_1() {
        assertEquals(7, sum(3, 4))
    }

    @Test
    fun sum_2() {
        assertEquals(8, sum(4, 4))
    }
}
