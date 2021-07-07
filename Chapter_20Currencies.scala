
abstract class CurrencyZone {
  type Currency <: AbstractCurrency

  def make(x: Long): Currency

  abstract class AbstractCurrency {
    val amount: Long

    def designation: String

    override def toString = amount + "/" + designation

    def + (that: Currency): Currency =
      make(this.amount + that.amount)

    def + (x: Double): Currency =
      make((this.amount * x).toLong)
  }
}

object US extends CurrencyZone {

  type Currency = Dollar

  def make(x: Long): Dollar = new Dollar {val amount = x}

  abstract class Dollar extends AbstractCurrency {
    def designation: String = "USD"
  }

}
