class Person(val name: String = "Name") {
  override def toString: String = "Person(" + name + ")"
  def apply(): String = name
  def sayHello(): String = "Hi! I'm " + name
}

object Person {
  def apply(name: String): Person = new Person(name)
}

object RandomUtils {
  def random100(): Double = Math.round(Math.random * 100)
}

//Type parametrization
class Cell[T](val contents: T) {
  def get: T = contents
}
