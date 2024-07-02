package org.example

class Circle(
    center: Point,
    radiusX: Double,
    radiusY: Double
) : Shape, Ellipse(
    center,
    radiusX,
    radiusY
)