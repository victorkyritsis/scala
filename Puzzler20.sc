
// def traceIt[T <: Iterator[String]](it: T) = {
def traceIt[T <: Iterator[_]](it: T) = {
  println(s"TRACE: using iterator '${it}'")
  it
}

val msg = "I love scala"
println("First Match Index: " + traceIt("a".r.findAllIn(msg)).start)

println("First Match Index: " + "a".r.findAllIn(msg).start)