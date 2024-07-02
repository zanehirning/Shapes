package org.example

open class Rectangle(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) : Shape {

    val topLeftCornerPoint: Point = Point(x, y)
    val bottomRightCornerPoint: Point = Point(x + width, y + height)

    init {
        if (width <= 0 || height <= 0) {
            throw IllegalArgumentException("Width and height must be positive")
        }
    }

    override fun getPoints(): List<Point> {
        return listOf(
            topLeftCornerPoint.clone(),
            Point(x + width, y),
            Point(x, y + height),
            bottomRightCornerPoint.clone()
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