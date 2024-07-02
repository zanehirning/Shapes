package org.example

class Triangle(
    val firstPoint: Point,
    val secondPoint: Point,
    val thirdPoint: Point
) : Shape {

    override fun getPoints(): List<Point> {
        return listOf(firstPoint.clone(), secondPoint.clone(), thirdPoint.clone())
    }

    override fun area(): Double {
        val area = .5 * (firstPoint.x * (secondPoint.y - thirdPoint.y)
                + secondPoint.x * (thirdPoint.y - firstPoint.y)
                + thirdPoint.x * (firstPoint.y - secondPoint.y))
        return Math.abs(area)
    }

    override fun move(xDelta: Double, yDelta: Double) {
        firstPoint.move(xDelta, yDelta)
        secondPoint.move(xDelta, yDelta)
        thirdPoint.move(xDelta, yDelta)
    }
}