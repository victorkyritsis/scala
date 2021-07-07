abstract class Element {
  //Parameterless method
  def contents: Array[String]

  //Parameterless method
  def height: Int = contents.length

  def width: Int = if(height == 0) 0 else contents(0).length

  def demo() = {
    println("Element's implementation invoked")
  }
}

// Parametric field definition
class ArrayElement(val contents: Array[String]) extends Element {
  override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}

class Cat {
  val dangerous = false
}

class Tiger(override val dangerous: Boolean, private var age: Int) extends Cat
