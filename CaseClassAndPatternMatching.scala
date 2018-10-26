// a sealed class cannot have any new subclass added except the ones in the same file
seal abstract class Expr
// this add a factory method with the name of the class. you can directly write Var("x")
// add all arguments in the parameter list of a case class implicitly get a val prefix, so they are maintained as fields
// add toString, equals, hashcode to your class

case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(Operator: String, left: Expr, right: Expr) extends Expr


def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e
  case BinOp("+", e, Number(0)) => e
  case BinOp("*", e, Number(1)) => e
  case UnOp(op, e) => UnOp(op, simplifyTop(e))
  case _ => expr
}

def describe(x: Any): String = x match {
  case 5 =>  "five"
  case true => "truth"
  case Nil => "the empty list"
  case "hello" => "hi"
  case _ => "something else"
}
