package org.example

interface Shapes {
    fun getPoints(): List<Point>
    fun area(): Double
    fun move(xDelta: Double, yDelta: Double)
}