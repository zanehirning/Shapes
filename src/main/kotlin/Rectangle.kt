package org.example

open class Rectangle(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) : Shape {

    private val topLeftCornerPoint: Point = Point(x, y)
    private val bottomRightCornerPoint: Point = Point(x + width, y + height)

    init {
        if (width <= 0 || height <= 0) {
            throw IllegalArgumentException("Width and height must be positive")
        }
    }

    override fun getPoints(): List<Point> {
        return listOf(
            topLeftCornerPoint.clone(),
            Point(x + width, y),
            bottomRightCornerPoint.clone(),
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