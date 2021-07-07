object Oh {
  def overloadA(u: Unit) = "I accept a Unit";

  def overloadA(u: Unit, n: Nothing) = "I accept a Unit and Nothing";
}