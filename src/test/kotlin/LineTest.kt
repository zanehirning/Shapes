import org.example.Line
import org.example.Point
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class LineTest {

    @Test
    fun testLineConstruction() {
        val startPoint = Point(1.0, 2.0)
        val endPoint = Point(3.0, 4.0)
        val line = Line(startPoint, endPoint)
        assertEquals(1.0, line.startPoint.x, "Start point x is not what is expected")
        assertEquals(2.0, line.startPoint.y, "Start point y is not what is expected")
        assertEquals(3.0, line.endPoint.x, "End point x is not what is expected")
        assertEquals(4.0, line.endPoint.y, "End point y is not what is expected")

        assertThrows<IllegalArgumentException> {
            Line(startPoint, startPoint)
        }
        assertThrows<IllegalArgumentException> {
            Line(endPoint, endPoint)
        }
        assertThrows<IllegalArgumentException> {
            Line(Point(-3.0, -5.0), Point(-3.0, -5.0))
        }
    }

    @Test
    fun testLineMove() {
        val startPoint = Point(1.0, 2.0)
        val endPoint = Point(3.0, 4.0)
        val line = Line(startPoint, endPoint)
        line.move(1.0, 2.0)
        assertEquals(2.0, line.startPoint.x, "Start point x is not what is expected")
        assertEquals(4.0, line.startPoint.y, "Start point y is not what is expected")
        assertEquals(4.0, line.endPoint.x, "End point x is not what is expected")
        assertEquals(6.0, line.endPoint.y, "End point y is not what is expected")

        val line2 = Line(Point(-1.0, -2.0), Point(-3.0, -4.0))
        line2.move(-1.0, -2.0)
        assertEquals(-2.0, line2.startPoint.x, "Start point x is not what is expected")
        assertEquals(-4.0, line2.startPoint.y, "Start point y is not what is expected")
        assertEquals(-4.0, line2.endPoint.x, "End point x is not what is expected")
        assertEquals(-6.0, line2.endPoint.y, "End point y is not what is expected")
    }

    @Test
    fun testLineSlope() {
        val line = Line(Point(1.0, 1.0), Point(2.0, 2.0))
        assertEquals(1.0, line.slope(), "Slope is not what is expected")

        val line2 = Line(Point(-1.0, -1.0), Point(-2.0, -2.0))
        assertEquals(1.0, line2.slope(), "Slope is not what is expected")

        val line3 = Line(Point(0.0, 0.0), Point(-1.0, 0.0))
        assertEquals(0.0, line3.slope(), "Slope is not what is expected")

        val line4 = Line(Point(0.0, 0.0), Point(1.0, -1.0))
        assertEquals(-1.0, line4.slope(), "Slope is not what is expected")

        val line5 = Line(Point(0.0, 0.0), Point(0.0, 1.0))
        assertThrows<ArithmeticException> {
            line5.slope()
        }
    }

    @Test
    fun testLineLength() {
        val line = Line(Point(0.0, 0.0), Point(2.0, 2.0))
        assertEquals(Math.sqrt(8.0), line.length(), "Length is not what is expected")

        val line2 = Line(Point(-1.0, -1.0), Point(-2.0, -2.0))
        assertEquals(Math.sqrt(2.0), line2.length(), "Length is not what is expected")

        val line3 = Line(Point(0.0, 0.0), Point(-1.0, 0.0))
        assertEquals(1.0, line3.length(), "Length is not what is expected")

        val line4 = Line(Point(0.0, 0.0), Point(1.0, -1.0))
        assertEquals(Math.sqrt(2.0), line4.length(), "Length is not what is expected")

        val line5 = Line(Point(0.0, 0.0), Point(0.0, 1.0))
        assertEquals(1.0, line5.length(), "Length is not what is expected")
    }
}