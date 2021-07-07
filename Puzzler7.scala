import collection.mutable.Buffer

//Scala allows the body of a function to reference variables
//that are not explicit function parameters, but are in scope
//at the moment the function is constructed.

//To access these free variables when the function is invoked
//in a different scope, Scala "closes over" them to create a closure

val accessors1 = Buffer.empty[() => Int]

val accessors2 = Buffer.empty[() => Int]

val data = Seq(100, 110, 120)

var j = 0
for(i <- 0 until data.length) {
  val currentJ = j
  accessors1 += (() => data(i))
  accessors2 += (() => data(currentJ))
  j += 1
}

accessors1.foreach( a1 => println(a1()) )
accessors2.foreach( a2 => println(a2()) )
