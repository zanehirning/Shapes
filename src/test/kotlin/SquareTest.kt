import org.example.Point
import org.example.Square
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SquareTest {

    @Test
    fun testSquareConstructor() {
        val square = Square(0.0, 0.0, 10.0, 10.0)
        assertTrue(square.x == 0.0, "Square x is not correct")
        assertTrue(square.y == 0.0, "Square y is not correct")
        assertTrue(square.width == 10.0, "Square width is not correct")
        assertTrue(square.height == 10.0, "Square height is not correct")

        assertThrows<IllegalArgumentException> {
            Square(5.0, 5.0, 0.0, 0.0)
        }
        assertThrows<IllegalArgumentException> {
            Square(5.0, 5.0, -10.0, -10.0)
        }
        assertThrows<IllegalArgumentException> {
            Square(5.0, 5.0, 10.0, 20.0)
        }
    }

    @Test
    fun testSquareArea() {
        val square = Square(0.0, 0.0, 10.0, 10.0)
        assertTrue(square.area() == 100.0, "Square area is not correct")

        val square2 = Square(10.0, 10.0, 5.0, 5.0)
        assertTrue(square2.area() == 25.0, "Square area is not correct")
    }

    @Test
    fun testSquareMove() {
        val square = Square(0.0, 0.0, 10.0, 10.0)
        square.move(5.0, 5.0)
        assertEquals(square.topLeftCornerPoint.x, 5.0, "Top Left Corner Point x is not correct")
        assertEquals(square.topLeftCornerPoint.y, 5.0, "Top Left Corner Point y is not correct")
        assertEquals(square.bottomRightCornerPoint.x, 15.0, "Top Left Corner Point x is not correct")
        assertEquals(square.bottomRightCornerPoint.y, 15.0, "Top Left Corner Point y is not correct")

        val square2 = Square(0.0, 0.0, 10.0, 10.0)
        square2.move(-5.0, -5.0)
        assertEquals(square2.topLeftCornerPoint.x, -5.0, "Top Left Corner Point x is not correct")
        assertEquals(square2.topLeftCornerPoint.y, -5.0, "Top Left Corner Point y is not correct")
        assertEquals(square2.bottomRightCornerPoint.x, 5.0, "Top Left Corner Point x is not correct")
        assertEquals(square2.bottomRightCornerPoint.y, 5.0, "Top Left Corner Point y is not correct")
    }

    @Test
    fun testSquareGetPoints() {
        val square = Square(0.0, 0.0, 10.0, 10.0)
        val expectedPoints = listOf(Point(0.0, 0.0), Point(10.0, 0.0), Point(0.0, 10.0), Point(10.0, 10.0))
        for (i in 1..4) {
            assertTrue(square.getPoints()[i - 1].x.equals(expectedPoints[i - 1].x), "Square x points are not correct")
            assertTrue(square.getPoints()[i - 1].y.equals(expectedPoints[i - 1].y), "Square y points are not correct")
        }

        val square2 = Square(-5.0, -5.0, 5.0, 5.0)
        val expectedPoints2 = listOf(Point(-5.0, -5.0), Point(0.0, -5.0), Point(-5.0, 0.0), Point(0.0, 0.0))
        for (i in 1..4) {
            assertTrue(square2.getPoints()[i - 1].x.equals(expectedPoints2[i - 1].x), "Square x points are not correct")
            assertTrue(square2.getPoints()[i - 1].y.equals(expectedPoints2[i - 1].y), "Square y points are not correct")
        }
    }

}