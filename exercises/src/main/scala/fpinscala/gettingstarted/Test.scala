package fpinscala.gettingstarted

object Test extends App {
  println("ex01")
  TestFib.main(Array())

  println("ex02")

  import PolymorphicFunctions._

  println("true: " + isSorted(Array(), (a: Int, b: Int) => a <= b))
  println("true: " + isSorted(Array(1), (a: Int, b: Int) => a <= b))
  println("true: " + isSorted(Array(1, 2, 3), (a: Int, b: Int) => a <= b))
  println("false: " + isSorted(Array(1, 3, 2), (a: Int, b: Int) => a <= b))

  def ex03() = {
    println("ex03")
    import PolymorphicFunctions._
    val f = (a: Int, b: Int) => (a + b).toString
    println("3: " + f(1, 2))
    println("3: " + curry(f)(1)(2))
  }
  ex03()

  def ex04() = {
    println("ex04")
    import PolymorphicFunctions._
    def f(a: Int)(b: Int) = (a + b).toString
    println("3: " + f(1)(2))
    println("3: " + uncurry(f)(1, 2))
  }
  ex04()
  def ex05() = {
    println("ex05")
    import PolymorphicFunctions._
    def f(a: Int) = a.toString
    def g(s: String) = s.toLong
    println("1: Long = " + g(f(1)))
    println("1: Long = " + compose(g, f)(1))
  }
  ex05()
}
