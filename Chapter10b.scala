abstract class Element {
  //Parameterless methods
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if(height == 0) 0 else contents(0).length

  override def toString = contents mkString "\n"
}


class ArrayElement(conts: Array[String]) extends Element {
  //fields and methods belong to the same namespace
  val contents: Array[String] = conts;
}

// Combine the parameter and the field in a single parametric field definition
class ArrayElementV2(val contents: Array[String]) extends Element

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length

  override def height = 1
}


class UniformElement(ch: Char,
                    override val width: Int,
                    override val height: Int) extends Element {
                      private val line = ch.toString * width
                      def contents = Array.fill(height)(line)
                    }
// The element Singleton Object
object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(ch: Char, width: Int, height: Int): Element =
    new  UniformElement(ch, width, height);

  def elem(s: String): Element = new LineElement(line)
}



class Cat {
  val dangerous = false;
}

class Tiger(override val dangerous: Boolean = true,
          private var age: Int) extends Cat
