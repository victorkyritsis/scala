// Declare a trait
trait TraceHashCode {
  override def hashCode: Int = {
    println(s"Trace: In hashCode for ${this}")
    super.hashCode;
  }
}

abstract case class Country(isoCode: String)

object Country {
  def apply(isoCode: String): Country = new Country(isoCode) with TraceHashCode;
}

def newSwitzFact = Country("CH")

println(newSwitzFact == newSwitzFact)

case class CountryWithTrace(isoCode: String) {
  override def hashCode: Int = {
    this.isoCode.##
  }
}
