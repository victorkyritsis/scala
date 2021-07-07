abstract class Expr

case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e //Double negation
  case BinOp("+", e, Number(0)) => e //Adding zero
  case BinOp("*", e, Number(1)) => e //Multiplying by one
  case _ => expr
}

def tupleDemo(expr: Any) =
  expr match {
    case (a, b, c) => println("matched " + a + b +c)
  }

def generalSize(x: Any) = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ => -1
}

def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}
