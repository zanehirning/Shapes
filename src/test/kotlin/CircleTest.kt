import org.example.Circle
import org.example.Point
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class CircleTest {

    @Test
    fun testCircleConstruction() {
        val center = Point(0.0, 0.0)
        val radius = 5.0
        val circle = Circle(center, radius)
        assertEquals(circle.center, center, "Center point is not equal")
        assertEquals(circle.radiusX, radius, "Radius X is not equal")
        assertEquals(circle.radiusY, radius, "Radius Y is not equal")

        assertThrows<IllegalArgumentException> {
            Circle(center, -1.0)
        }
    }

    @Test
    fun testCircleArea() {
        val center = Point(0.0, 0.0)
        val radius = 5.0
        val circle = Circle(center, radius)
        assertEquals(circle.area(), Math.PI * radius * radius, 0.0001)
        assertEquals(circle.area(), Math.PI * circle.radiusX * circle.radiusY, 0.0001)
    }

    @Test
    fun testCircleMove() {
        val center = Point(0.0, 0.0)
        val circle = Circle(center, 5.0)
        circle.move(1.0, 3.0)
        assertEquals(circle.center.x, 1.0, "Circle center was not moved correctly in x direction")
        assertEquals(circle.center.y, 3.0, "Circle center was not moved correctly in y direction")

        circle.move(-1.0, -3.0)
        assertEquals(circle.center.x, 0.0, "Circle center was not moved correctly in x direction")
        assertEquals(circle.center.y, 0.0, "Circle center was not moved correctly in y direction")
    }

    @Test
    fun testCircleGetPoints() {
        val center = Point(0.0, 0.0)
        val circle = Circle(center, 5.0)
        val points = circle.getPoints()
        assertEquals(points.size, 1, "Circle should have only one point")
        assertEquals(points[0].x, center.x, "Center point x is not equal")
        assertEquals(points[0].y, center.y, "Center point y is not equal")
    }
}