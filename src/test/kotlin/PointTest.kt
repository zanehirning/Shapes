import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PointTest {

    @Test
    fun testPointConstruction() {
        val point = Point(1.0, 2.0)
        assertEquals(1.0, point.x, "Point x is not what is expected")
        assertEquals(2.0, point.y, "Point y is not what is expected")

        val point2 = Point(-1.0, -2.0)
        assertEquals(-1.0, point2.x, "Point x is not what is expected")
        assertEquals(-2.0, point2.y, "Point y is not what is expected")
    }

    @Test
    fun testPointMove() {
        val point = Point(1.0, 2.0)
        point.move(3.0, 4.0)
        assertEquals(4.0, point.x, "Point x is not what is expected")
        assertEquals(6.0, point.y, "Point y is not what is expected")

        val point2 = Point(-1.0, -2.0)
        point2.move(-3.0, -4.0)
        assertEquals(-4.0, point2.x, "Point x is not what is expected")
        assertEquals(-6.0, point2.y, "Point y is not what is expected")
    }

    @Test
    fun testPointClone() {
        val point = Point(1.0, 2.0)
        val pointClone = point.clone()
        assertEquals(1.0, pointClone.x, "Point x is not what is expected")
        assertEquals(2.0, pointClone.y, "Point y is not what is expected")
        assertNotEquals(point, pointClone, "Point clone should not be the same object as the original")
    }
}