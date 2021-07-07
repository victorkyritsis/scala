trait A {
  def a: Unit = println("a")
}

trait B {
  def b: Unit
}

class C extends A with B {
  def b: Unit = println("b")
}

object C {
  def apply(): C = new C()
}
