class Pair[T](val first: T, val second: T) {

  def replaceFirst[R >: T](newFirst: R) = new Pair[R](first, second)

}

trait Friend[-T] {
  def befriend(someone: T)
}

class Person extends Friend[Person]{ def befriend(someone: Person) = ??? }

class Student extends Person

val susan = new Student

val fred = new Person

def makeFriendWith(s: Student, f: Friend[Student]){ f.befriend(s) }
