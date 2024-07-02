import org.example.Point
import org.example.Triangle
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class TriangleTest {

    @Test
    fun testTriangleConstructor() {
        val firstPoint = Point(1.0, 2.0)
        val secondPoint = Point(3.0, 4.0)
        val thirdPoint = Point(6.0, 6.0)
        val triangle = Triangle(firstPoint, secondPoint, thirdPoint)
        assertEquals(firstPoint, triangle.firstPoint, "Triangle first point is not what is expected")
        assertEquals(secondPoint, triangle.secondPoint, "Triangle second point is not what is expected")
        assertEquals(thirdPoint, triangle.thirdPoint, "Triangle third point is not what is expected")

        assertThrows<IllegalArgumentException> {
            Triangle(firstPoint, firstPoint, thirdPoint)
        }
        assertThrows<IllegalArgumentException> {
            Triangle(firstPoint, secondPoint, firstPoint)
        }
        assertThrows<IllegalArgumentException> {
            Triangle(firstPoint, secondPoint, secondPoint)
        }
        assertThrows<IllegalArgumentException> {
            Triangle(Point(1.0, 1.0), Point(2.0, 2.0), Point(3.0, 3.0))
        }
    }

    @Test
    fun testTriangleMove() {
        val firstPoint = Point(1.0, 2.0)
        val secondPoint = Point(3.0, 4.0)
        val thirdPoint = Point(6.0, 6.0)
        val triangle = Triangle(firstPoint, secondPoint, thirdPoint)
        triangle.move(1.0, 2.0)
        assertEquals(2.0, triangle.firstPoint.x, "Triangle first point x is not what is expected")
        assertEquals(4.0, triangle.firstPoint.y, "Triangle first point y is not what is expected")
        assertEquals(4.0, triangle.secondPoint.x, "Triangle second point x is not what is expected")
        assertEquals(6.0, triangle.secondPoint.y, "Triangle second point y is not what is expected")
        assertEquals(7.0, triangle.thirdPoint.x, "Triangle third point x is not what is expected")
        assertEquals(8.0, triangle.thirdPoint.y, "Triangle third point y is not what is expected")

        triangle.move(-1.0, -2.0)
        assertEquals(1.0, triangle.firstPoint.x, "Triangle first point x is not what is expected")
        assertEquals(2.0, triangle.firstPoint.y, "Triangle first point y is not what is expected")
        assertEquals(3.0, triangle.secondPoint.x, "Triangle second point x is not what is expected")
        assertEquals(4.0, triangle.secondPoint.y, "Triangle second point y is not what is expected")
        assertEquals(6.0, triangle.thirdPoint.x, "Triangle third point x is not what is expected")
        assertEquals(6.0, triangle.thirdPoint.y, "Triangle third point y is not what is expected")
    }

    @Test
    fun testTriangleArea() {
        val firstPoint = Point(1.0, 1.0)
        val secondPoint = Point(2.0, 1.0)
        val thirdPoint = Point(1.0, 2.0)
        val triangle = Triangle(firstPoint, secondPoint, thirdPoint)
        assertEquals(.5, triangle.area(), "Triangle area is not what is expected")

        val firstPoint2 = Point(1.0, 1.0)
        val secondPoint2 = Point(2.0, 1.0)
        val thirdPoint2 = Point(1.0, 4.0)
        val triangle2 = Triangle(firstPoint2, secondPoint2, thirdPoint2)
        assertEquals(1.5, triangle2.area(), "Triangle area is not what is expected")
    }

    @Test
    fun testTriangleGetPoints() {
        val firstPoint = Point(1.0, 2.0)
        val secondPoint = Point(3.0, 4.0)
        val thirdPoint = Point(6.0, 6.0)
        val triangle = Triangle(firstPoint, secondPoint, thirdPoint)
        for (i in 0..2) {
            val point = triangle.getPoints()[i]
            assertEquals(point.x, when (i) {
                0 -> firstPoint.x
                1 -> secondPoint.x
                2 -> thirdPoint.x
                else -> throw IllegalArgumentException("Invalid index")
            }, "Triangle x is not what is expected")
            assertEquals(point.y, when (i) {
                0 -> firstPoint.y
                1 -> secondPoint.y
                2 -> thirdPoint.y
                else -> throw IllegalArgumentException("Invalid index")
            }, "Triangle y is not what is expected")
        }
    }
}