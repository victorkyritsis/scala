import collection.mutable.Buffer


def applyNMulti[T](n: Int)(arg: T, f: T => T) =
  (1 to n).foldLeft(arg){ (acc, _) => f(acc) }

def applyNCurried[T](n: Int)(arg: T)(f: T => T) =
  (1 to n).foldLeft(arg){ (acc, _) => f(acc) }

def nextInt(n: Int) = n + 1;

def nextNumber[N](n: N)(implicit numericOps: Numeric[N]) =
  numericOps.plus(numericOps.times(n, n), numericOps.one)



def myFunction[T: Numeric](number: T) = {
  var innerVar = 1.0
  innerVar = implicitly[Numeric[T]].times(number, number) + innerVar
  innerVar
}


println(applyNMulti(3)(2, nextInt))
println(applyNCurried(3)(2)(nextInt))

// println(applyNMulti(3)(2.0, nextNumber))
// println(applyNCurried(3)(2.0)(nextNumber))

myFunction(2.0)
