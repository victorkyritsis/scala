trait A {
  val audience: String
  println("Hello " + audience)
}

class BEarlyDef(a: String = "World") extends {
  val audience = a;
} with A {
  println("I repeat: Hello " + audience);
};
