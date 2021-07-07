
// Every trait has a single parameterless constructor
trait Logger {
  println("Logger constructor")
}

trait FileLogger extends Logger {
  val filename: String
  println("FileLogger constructor")
}

trait ShortLogger extends Logger {
  println("ShortLogger constructor")
}


class Account {
  println("Account constructor")
}

class SavingsAccount extends Account {
  println("Savings Account constructor")
}

new SavingsAccount with FileLogger /*with ShortLogger*/ {
  override val filename = "";
}