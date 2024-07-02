import org.example.Point
import org.example.Rectangle
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RectangleTest {
    @Test
    fun testRectangleConstruction() {
        val rect1 = Rectangle(0.0, 0.0, 10.0, 10.0)
        assertTrue(rect1.x == 0.0, "Rectangle x is not correct")
        assertTrue(rect1.y == 0.0, "Rectangle y is not correct")
        assertTrue(rect1.width == 10.0, "Rectangle width is not correct")
        assertTrue(rect1.height == 10.0, "Rectangle height is not correct")

        assertThrows<IllegalArgumentException> {
            Rectangle(5.0, 5.0, 0.0, 0.0)
        }
        assertThrows<IllegalArgumentException> {
            Rectangle(5.0, 5.0, 0.0, 0.0)
        }
        assertThrows<IllegalArgumentException> {
            Rectangle(5.0, 5.0, -20.0, -20.0)
        }
    }

    @Test
    fun testRectangleArea() {
        val rect1 = Rectangle(0.0, 0.0, 10.0, 10.0)
        assertTrue(rect1.area() == 100.0, "Rectangle area is not correct")

        val rect2 = Rectangle(0.0, 0.0, .5, 10.0)
        assertTrue(rect2.area() == 5.0, "Rectangle area is not correct")
    }

    @Test
    fun testRectangleMove() {
        val rect1 = Rectangle(0.0, 0.0, 10.0, 10.0)
        rect1.move(5.0, 5.0)
        rect1.javaClass.getDeclaredField("topLeftCornerPoint").setAccessible(true)
        rect1.javaClass.getDeclaredField("bottomRightCornerPoint").setAccessible(true)
        assertEquals(rect1.topLeftCornerPoint.x, 5.0, "Top Left Corner Point x is not correct")
        assertEquals(rect1.topLeftCornerPoint.y, 5.0, "Top Left Corner Point y is not correct")
        assertEquals(rect1.bottomRightCornerPoint.x, 15.0, "Top Left Corner Point x is not correct")
        assertEquals(rect1.bottomRightCornerPoint.y, 15.0, "Top Left Corner Point y is not correct")

        val rect2 = Rectangle(0.0, 0.0, 10.0, 10.0)
        rect2.move(-5.0, -5.0)
        rect2.javaClass.getDeclaredField("topLeftCornerPoint").setAccessible(true)
        rect2.javaClass.getDeclaredField("bottomRightCornerPoint").setAccessible(true)
        assertEquals(rect2.topLeftCornerPoint.x, -5.0, "Top Left Corner Point x is not correct")
        assertEquals(rect2.topLeftCornerPoint.y, -5.0, "Top Left Corner Point y is not correct")
        assertEquals(rect2.bottomRightCornerPoint.y, 5.0, "Top Left Corner Point y is not correct")
        assertEquals(rect2.bottomRightCornerPoint.y, 5.0, "Top Left Corner Point y is not correct")
    }

    @Test
    fun testRectangleGetPoints() {
        val rect1 = Rectangle(0.0, 0.0, 10.0, 10.0)
        val expectedPoints = listOf(Point(0.0, 0.0), Point(10.0, 0.0), Point(0.0, 10.0), Point(10.0, 10.0))
        for (i in 1..4) {
            assertTrue(rect1.getPoints()[i - 1].x.equals(expectedPoints[i - 1].x), "Rectangle x points are not correct")
            assertTrue(rect1.getPoints()[i - 1].y.equals(expectedPoints[i - 1].y), "Rectangle y points are not correct")
        }

        val rect2 = Rectangle(-5.0, -5.0, 10.0, 10.0)
        val expectedPoints2 = listOf(Point(-5.0, -5.0), Point(5.0, -5.0), Point(-5.0, 5.0), Point(5.0, 5.0))
        for (i in 1..4) {
            assertTrue(rect2.getPoints()[i - 1].x.equals(expectedPoints2[i - 1].x), "Rectangle x points are not correct")
            assertTrue(rect2.getPoints()[i - 1].y.equals(expectedPoints2[i - 1].y), "Rectangle y points are not correct")
        }
    }
}