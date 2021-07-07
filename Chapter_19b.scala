class Cell[T](init: T) {
  private[this] var current = init

  def get = current

  def set(x: T) = current = x;
}

def nextInt: Int => Int = n => n * n

def nextNumber[N](n: N)(implicit numericOps: Numeric[N]) =
  numericOps.plus(numericOps.times(n, n), numericOps.one)

def applyNMulti[T](n: Int)(arg: T, f: T => T) =
  (1 to n).foldLeft(arg) {(acc, _) => f(acc)}

def applyNCurried[T](n: Int)(arg: T)(f: T => T) =
  (1 to n).foldLeft(arg) {(acc, _) => f(acc)}
