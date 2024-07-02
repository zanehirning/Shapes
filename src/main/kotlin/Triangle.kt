package org.example

class Triangle(
    val firstPoint: Point,
    val secondPoint: Point,
    val thirdPoint: Point
) : Shape {

    init {
        if (firstPoint == secondPoint || firstPoint == thirdPoint || secondPoint == thirdPoint) {
            throw IllegalArgumentException("Points must be distinct")
        }
        if (firstPoint.x == secondPoint.x && firstPoint.x == thirdPoint.x) {
            throw IllegalArgumentException("Points must not be on the same vertical line")
        }
        if (firstPoint.y == secondPoint.y && firstPoint.y == thirdPoint.y) {
            throw IllegalArgumentException("Points must not be on the same horizontal line")
        }
        if (this.area() == 0.0) {
            throw IllegalArgumentException("Points must not lie on the same line")
        }
    }

    override fun getPoints(): List<Point> {
        return listOf(firstPoint.clone(), secondPoint.clone(), thirdPoint.clone())
    }

    override fun area(): Double {
        val area = .5 * (firstPoint.x * (secondPoint.y - thirdPoint.y) +
                secondPoint.x * (thirdPoint.y - firstPoint.y) +
                thirdPoint.x * (firstPoint.y - secondPoint.y))
        return Math.abs(area)
    }

    override fun move(xDelta: Double, yDelta: Double) {
        firstPoint.move(xDelta, yDelta)
        secondPoint.move(xDelta, yDelta)
        thirdPoint.move(xDelta, yDelta)
    }
}