abstract class Account {
  def withdraw(amount: Double)
}

trait Logger {
  // Note that you don't need to declare the method as abstract
  // An unimplemented method in a trait is automatically abstract
  def log(msg: String)
}

class ConsoleLogger extends Logger with Cloneable with Serializable {
  override def log(msg: String): Unit = {
    println(msg)
  }
}

trait ConsoleLogger2 extends Logger{
  def log(msg: String): Unit = println(msg)
}

// The ConsoleLogger2 functionality is "mixed in" with the SavingsAccount class
abstract class SavingsAccount extends Account with Logger {
  override def withdraw(amount: Double): Unit = {
    log("Inside withdraw function")
  }
}

// When calling log on the acct object, the log method of the ConsoleLogger2 trait executes
val acct = new SavingsAccount with ConsoleLogger2;