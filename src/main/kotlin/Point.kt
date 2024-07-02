package org.example

class Point(
    var x: Double,
    var y: Double
){
    fun move(xDelta: Double, yDelta: Double) {
        this.x += xDelta
        this.y += yDelta
    }

    fun clone(): Point {
        return Point(this.x, this.y)
    }
}