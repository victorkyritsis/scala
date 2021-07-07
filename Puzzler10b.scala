// Declare a trait
trait TraceHashCode {
  override def hashCode: Int = {
    println(s"Trace: In hashCode for ${this}")
    super.hashCode;
  }
}

case class _Country(isoCode: String)

// Extending case classes is not considered good practice
class Country(isoCode: String) extends _Country(isoCode: String) with TraceHashCode

object Country {
  def apply(isoCode: String): Country = new Country(isoCode)
}

def newSwitzSubcl = Country("CH")

println(newSwitzSubcl == newSwitzSubcl)
