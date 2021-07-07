object XY {

  object X {
    val value: Int = Y.value + 1
  }

  object Y {
    val value: Int = X.value + 1
  }
}

println(if (math.random > 0.5) XY.X.value else XY.Y.value)

object XY2 {
  lazy val xvalue: Int = yvalue + 1
  lazy val yvalue: Int = xvalue + 1
}


println(if (math.random > 0.5) XY2.xvalue else XY2.yvalue)
