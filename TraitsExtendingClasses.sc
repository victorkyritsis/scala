import java.io.IOException

trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger {
  override def log(msg: String) = println(msg)
}

// When a trait extends a class, the superclass is present in any class mixing in the trait
trait LoggedException extends  ConsoleLogger {

  // LoggedException has a self type of Exception
  // It can only be mixed into subclasses of Exception
  this: {def getMessage(): String} =>

  def log(): Unit = {
    log(getMessage())
  }
}

class UnhappyException /*extends IOException */ extends LoggedException