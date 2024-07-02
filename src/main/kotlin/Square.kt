package org.example

class Square(
    private val x: Double,
    private val y: Double,
    private val width: Double,
    private val height: Double
) : Shape, Rectangle(
    x,
    y,
    width,
    height
) {
    init {
        if (width != height) {
            throw IllegalArgumentException("Width and height must be equal")
        }
    }
}