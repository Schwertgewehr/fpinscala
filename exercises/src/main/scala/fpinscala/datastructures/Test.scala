package fpinscala.datastructures

object Test extends App {
  println("#ex01")
  println("3=" + MyList.casex)

  def ex02() = {
    println("#ex02")
    println("Nil = " + MyList.tail(MyList(1)))
    println("2,Nil = " + MyList.tail(MyList(1, 2)))
    println("None = " + MyList.tailOption(MyList()))
    println("Some(Nil) = " + MyList.tailOption(MyList(1)))
    println("Some(2,Nil) = " + MyList.tailOption(MyList(1, 2)))
  }
  ex02()

  def ex03() = {
    println("#ex03")
    println("1,Nil = " + MyList.setHead(Nil, 1))
    println("2,Nil = " + MyList.setHead(MyList(1), 2))
  }
  ex03()

  def ex04() = {
    println("#ex04")
    println("Nil = " + MyList.drop(Nil, 1))
    println("Nil = " + MyList.drop(MyList(1), 1))
    println("2,3,4,5,Nil = " + MyList.drop(MyList(1,2,3,4,5), 1))
  }
  ex04()

  def ex05() = {
    println("#ex05")
    println("Nil = " + MyList.dropWhile(Nil: MyList[String])(_.length < 2))
    println("444,Nil = " + MyList.dropWhile(MyList("1", "2", "3", "444"))(_.length < 2))
  }
  ex05()

  def ex10() = {
    println("#ex10")
    println("123 = " + MyList.foldLeft(MyList(1,2,3), "")(_ + _))
  }
  ex10()

  def ex11() = {
    println("#ex11")
    println("0 = " + MyList.sum3(Nil))
    println("10 = " + MyList.sum3(MyList(1, 2, 3, 4)))
    println("1.0 = " + MyList.product3(Nil))
    println("24.0 = " + MyList.product3(MyList(1.0, 2.0, 3.0, 4.0)))
  }
  ex11()

}
