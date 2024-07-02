package org.example

class Circle(
    private var center: Point,
    private var radiusX: Double,
    private var radiusY: Double
) : Shape, Ellipse(
    center,
    radiusX,
    radiusY
)