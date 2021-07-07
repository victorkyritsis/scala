trait Abstract {

  //abstract type
  type T

  //abstract method
  def transform(x: T): T

  //abstract val
  val initial: T

  //abstract var
  var current: T
}

abstract class Clazz {
  type T

  var aVal: String = ""
}

class Concrete extends Abstract {
  type T = String

  def transform(x: String): String = x + x

  val initial = "hi"

  var current = initial
}

// Abstract vals
abstract class Fruit {
  val v: String

  def m: String
}

abstract class Apple extends Fruit {
  val v: String

  val m: String
}


trait AbstractTime {
  var hour: Int

  var minute: Int
}

/**/
trait RationalTrait {
  val numerArg: Int

  val denomArg: Int

  require(denomArg != 0)

  private def gcd(a: Int, b: Int): Int =
    if( b == 0 ) a else gcd(b, a % b)

  private val g = gcd(numerArg, denomArg)

  val numer = numerArg / g

  val denom = denomArg / g

  override def toString = numer + "/" + denom
}

/**/
trait LazyNationalTrait {

  println("Inside Trait")

  val numerArg: Int

  val denomArg: Int

  lazy val numer = numerArg / g

  lazy val denom = denomArg / g

  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }

  private def gcd(a: Int, b: Int): Int =
    if( b == 0 ) a else gcd(b, a % b)

  override def toString(): String = {
    println("Inside toString")
    numer + "/" + denom
  }
}


object twoThirds extends {
  // Pre-initailized fields. Let's you initialize a field of a subclass
  // before the superclass is called.
  val numerArg = 2
  val denomArg = 3
} with RationalTrait


class RationalClass(n: Int, d: Int) extends {
  val numerArg = n
  val denomArg = d
} with RationalTrait {
  def + (that: RationalClass) = new RationalClass(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
}


new LazyNationalTrait {
  println("Inside anonymous subclass")

  val numerArg = 4

  val denomArg = 8

}
