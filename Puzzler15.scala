var x = 0

def counter() = {x += 1; x}

def add(a: Int)(b: Int) = a + b

//A function value
val adder1 = add(counter)(_)

val adder2 = add(counter) _
