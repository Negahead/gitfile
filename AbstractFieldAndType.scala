trait Abstract {
  type T  // this is abstract type
  // method definition may be implmented by concrete method or concrete value definition
  def transform: T
  // any implmentation must be also a val definition, not var, not def
  val initial: T
  val current: T
  
  val hour: Int  // abstrct var, this also implicitly define a getter method hour and a setter method hour_=
}


class Concrete extends Abstract {
  type T = String
  
  val transform = "hello"
  
  val current = initial
  
  override var hour: Int = 23
}

object Will {
  private def privateName = "dopa"
  def name(surName: String): String = "Chow"
}

