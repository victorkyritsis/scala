class Food

abstract class Animal {

  //SuitableFood is modeled as an abstract type
  type SuitableFood <: Food

  def eat(food: SuitableFood)
}

class Grass extends Food

class Cow extends Animal {
  type SuitableFood = Grass

  override def eat(food: Grass) = {}
}

class Pasture {
  var animals: List[Animal {type SuitableFood = Grass}] = Nil
}


object Color extends Enumeration {
  val RED = Value

  val GREEN = Value

  val BLUE = Value
}

object Direction extends Enumeration {
  val NORTH = Value("North")

  val EAST = Value("East")

  val SOUTH = Value("South")

  val WEST = Value("West")
}
