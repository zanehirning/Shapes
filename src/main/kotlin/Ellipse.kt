package org.example

open class Ellipse(
    private var center: Point,
    private var radiusX: Double,
    private var radiusY: Double
) : Shape {

    init {
        if (radiusX <= 0 || radiusY <= 0) {
            throw IllegalArgumentException("Radii must be positive")
        }
    }

    override fun getPoints(): List<Point> {
        return listOf(center.clone())
    }

    override fun move(xDelta: Double, yDelta: Double) {
        this.center.move(xDelta, yDelta)
    }

    override fun area(): Double {
        return Math.PI * radiusX * radiusY
    }
}