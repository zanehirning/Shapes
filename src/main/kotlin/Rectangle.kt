package org.example

class Rectangle(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) : Shape {

    private val topLeftCornerPoint: Point = Point(x, y)
    private val bottomRightCornerPoint: Point = Point(x + width, y + height)

    override fun getPoints(): List<Point> {
        return listOf(
            topLeftCornerPoint,
            Point(x + width, y),
            bottomRightCornerPoint,
            Point(x, y + height)
        )
    }

    override fun area(): Double {
        return width * height
    }

    override fun move(xDelta: Double, yDelta: Double) {
        topLeftCornerPoint.move(xDelta, yDelta)
        bottomRightCornerPoint.move(xDelta, yDelta)
    }
}