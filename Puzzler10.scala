// Declare a trait
trait TraceHashCode {
  override def hashCode: Int = {
    println(s"Trace: In hashCode for ${this}")
    super.hashCode;
  }
}

// mix in trait at instantiation
// Mixing in TraceHashCode on instantiation leaves equals and hashCode behavior unaffected
case class Country(isoCode: String)

def newSwitzInst = new Country("CH") with TraceHashCode

import collection.immutable.HashSet

val countriesInst = HashSet(newSwitzInst)
println(countriesInst.iterator contains newSwitzInst) // Calls equals
println(countriesInst contains newSwitzInst)          // Calls hashCode

// mix in trait at declaration time
// Declaring CountryWithTrace as extending from TraceHashCode switches off the
//generated hashCode method for case classes.
case class CountryWithTrace(isoCode: String) extends TraceHashCode
def newSwitzDecl = CountryWithTrace("CH")

val countriesDecl = HashSet(newSwitzDecl)
println(countriesDecl.iterator contains newSwitzDecl) // Calls equals
println(countriesDecl contains newSwitzDecl)          // Calls hashCode
