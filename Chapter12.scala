// A class can mix in any number of traits

trait Philosophical {
  def philosophize() = {
    println("I consume memory, therefore I am")
  }
}


class Animal

trait HasLegs


// Class Frog mixes in
class Frog extends Animal with Philosophical {
  override def toString = "green"

  override def philosophize() = {
    println("It ain't easy being " + toString + "!")
  }
}
