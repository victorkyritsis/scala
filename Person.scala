class Person(val name: String) {
  override def toString = "Person(" + name + ")";
}

object Person {
  def apply(name: String): Person = new Person(name)
}
