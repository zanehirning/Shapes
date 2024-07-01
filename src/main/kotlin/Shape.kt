package org.example

interface Shape {
    fun getPoints(): List<Point>
    fun area(): Double
    fun move(xDelta: Double, yDelta: Double)
}