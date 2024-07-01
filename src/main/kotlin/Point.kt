package org.example

class Point(
    private var x: Double,
    private var y: Double
){
    fun getX(): Double {
        return this.x
    }

    fun getY(): Double {
        return this.y
    }

    fun move(xDelta: Double, yDelta: Double) {
        this.x += xDelta
        this.y += yDelta
    }

    fun clone(): Point {
        return Point(this.x, this.y)
    }
}