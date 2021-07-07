// You can add, to a class or an object, multiple traits that invoke each pther starting with thw
// last one

class SavingsAccount

trait Logger {
  def log(msg: String)

  def info(msg: String) {log(s"INFO: $msg")}

  def warn(msg: String) {log(s"WARN: $msg")}

  def severe(msg: String) {log(s"SEVERE: $msg")}
}

trait ConsoleLogger extends Logger{
  def log(msg: String): Unit = println(msg)
}

trait TimeStampLogger extends Logger {

  abstract override def log(msg: String):Unit = {
    super.log(s"${java.time.Instant.now()} ${msg}")
  }
}

trait ShortLogger extends Logger {

  val maxLength: Int

  abstract override def log(msg: String):Unit = {
    // in traits super.log does not have the same meaning as it does with classes.
    // super.log calls the log method of another trait, which depends on the order
    // in which the traits are added
    super.log(
      if(msg.length <= maxLength) msg else s"${msg.substring(0, 12)}..."
    )
  }
}

 val acct1 = new SavingsAccount with TimeStampLogger with ShortLogger {
   val maxLength = 20
 }
// val acct2 = new SavingsAccount with ShortLogger with TimeStampLogger
// acct1.log("My Short message")
// acct2.log("My Short message")