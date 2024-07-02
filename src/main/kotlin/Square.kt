package org.example

class Square(
    x: Double,
    y: Double,
    width: Double,
    height: Double
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