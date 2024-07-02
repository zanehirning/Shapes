package org.example

class Line(
    var startPoint: Point,
    var endPoint: Point
) {

    init {
        if (startPoint.getX() == endPoint.getX() && startPoint.getY() == endPoint.getY()) {
            throw IllegalArgumentException("Start and end points must be different")
        }
    }

    fun getStartPoint(): Point {
        return this.startPoint.clone()
    }

    fun getEndPoint(): Point {
        return this.endPoint.clone()
    }

    fun move(xDelta: Double, yDelta: Double) {
        this.startPoint.move(xDelta, yDelta)
        this.endPoint.move(xDelta, yDelta)
    }

    fun slope(): Double {
        return (endPoint.getY() - startPoint.getY()) / (endPoint.getX() - startPoint.getX())
    }

    fun length(): Double {
        return Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2.0) + Math.pow(endPoint.getY() - startPoint.getY(), 2.0))
    }
}