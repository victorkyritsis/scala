
class Animal {
  def func() {
    println("Animal ...")
  }
}

trait HasLegs extends Animal{
  abstract override def func() {
    super.func()
    println("HasLegs ...");
  }
}

trait FourLegged extends Animal{
  abstract override def func() {
    super.func()
    println("FourLegged ...");
  }
}

class Cat extends Animal with HasLegs with FourLegged  {
  override def func() {
    super.func()
    println("Cat ... ")
  }
}
