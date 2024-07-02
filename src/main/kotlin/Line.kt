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
        return (endPoint.y - startPoint.y) / (endPoint.x - startPoint.x)
    }

    fun length(): Double {
        return Math.sqrt(Math.pow(endPoint.x - startPoint.x, 2.0) + Math.pow(endPoint.y - startPoint.y, 2.0))
    }
}