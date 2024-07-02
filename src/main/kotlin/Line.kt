package org.example

class Line(
    var startPoint: Point,
    var endPoint: Point
) {

    init {
        if (startPoint.x == endPoint.x && startPoint.y == endPoint.y) {
            throw IllegalArgumentException("Start and end points must be different")
        }
    }

    fun move(xDelta: Double, yDelta: Double) {
        this.startPoint.move(xDelta, yDelta)
        this.endPoint.move(xDelta, yDelta)
    }

    fun slope(): Double {
        if (endPoint.x - startPoint.x == 0.0) {
            throw ArithmeticException()
        }
        if (endPoint.y - startPoint.y == 0.0) {
            return 0.0
        }
        return (endPoint.y - startPoint.y) / (endPoint.x - startPoint.x)
    }

    fun length(): Double {
        return Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2.0) + Math.pow(endPoint.y - startPoint.y, 2.0))
    }
}