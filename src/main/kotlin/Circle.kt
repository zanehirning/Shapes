package org.example

class Circle(
    center: Point,
    radius: Double
) : Shape, Ellipse(
    center,
    radius,
    radius
) {
    init {
        if (this.radiusX != this.radiusY) {
            throw IllegalArgumentException("Radii must be equal")
        }
    }
}