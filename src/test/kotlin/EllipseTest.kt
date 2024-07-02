import org.example.Ellipse
import org.example.Point
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class EllipseTest {

    @Test
    fun testEllipseConstruction() {
        val center = Point(0.0, 0.0)
        val radiusX = 5.0
        val radiusY = 3.0
        val ellipse = Ellipse(center, radiusX, radiusY)
        assertEquals(ellipse.center, center, "Center point is not equal")
        assertEquals(ellipse.radiusX, radiusX, "Radius X is not equal")
        assertEquals(ellipse.radiusY, radiusY, "Radius Y is not equal")

        assertThrows<IllegalArgumentException> {
            Ellipse(center, -1.0, 3.0)
        }
        assertThrows<IllegalArgumentException> {
            Ellipse(center, 1.0, -3.0)
        }
    }

    @Test
    fun testEllipseArea() {
        val center = Point(0.0, 0.0)
        val radiusX = 5.0
        val radiusY = 3.0
        val ellipse = Ellipse(center, radiusX, radiusY)
        assertEquals(ellipse.area(), Math.PI * radiusX * radiusY, 0.0001)
    }

    @Test
    fun testEllipseMove() {
        val center = Point(0.0, 0.0)
        val ellipse = Ellipse(center, 3.0, 5.0)
        ellipse.move(1.0, 3.0)
        assertEquals(ellipse.center.x, 1.0, "Ellipse center was not moved correctly in x direction")
        assertEquals(ellipse.center.y, 3.0, "Ellipse center was not moved correctly in y direction")

        ellipse.move(-1.0, -3.0)
        assertEquals(ellipse.center.x, 0.0, "Ellipse center was not moved correctly in x direction")
        assertEquals(ellipse.center.y, 0.0, "Ellipse center was not moved correctly in y direction")
    }

    @Test
    fun testEllipseGetPoints() {
        val center = Point(0.0, 0.0)
        val ellipse = Ellipse(center, 3.0, 5.0)
        val points = ellipse.getPoints()
        assertEquals(points.size, 1, "Ellipse should have only one point")
        assertEquals(points[0].x, center.x, "Center point x is not equal")
        assertEquals(points[0].y, center.y, "Center point y is not equal")
    }
}