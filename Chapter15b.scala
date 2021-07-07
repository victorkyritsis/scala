import math.{E, Pi}

//make the superclass of your case classes sealed
sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// selector match {alternatives}

def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e
  case BinOp("+", e, Number(0)) => e
  case BinOp("*", e, Number(1)) => e
  case _ => expr
}

def simplifyTop2(expr: Expr): Unit = expr match {
  case BinOp(_, _, _) => println(expr + " is a binary operation")
  case _ => println("It's something else")
}


def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "Hello" => "Hi"
  case Nil => "The empty list"
  case _ => "Something else"
}

def sequencePattern(expr: Any) = expr match {
  // If you want to match against a sequence without specifying how long it can be
  case List(0, _*) => println("Found it")
  case _ =>
}




// Typed patterns as a convenient replacement for type tests and type casts
def generalSize(x: Any) = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ => -1
}

def typedTest(x: Any): Int = {
  if(x.isInstanceOf[String]) {
    (x.asInstanceOf[String]).length
  } else {
    -1
  }
}

def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}


UnOp("abs", UnOp("abs", Number(4))) match {
  case UnOp("abs", e @ UnOp("abs", x)) => e
  case _ =>
}

def simplifyAdd(e: Expr) = e match {
  // A pattern guard comes after a pattern and starts with an if
  case BinOp("+", x, y) if(x == y) => BinOp("*", x, Number(2))
  case _ => e
}

//
def describe2(e: Expr): String = (e: @unchecked) match {
  case Number(_) => "A number"
  case Var(_) => "a variable"
  // case _ => throw new RuntimeException
}

def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}

val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

val second: PartialFunction[List[Int], Int] = {
  case x :: y :: _ => y
}
