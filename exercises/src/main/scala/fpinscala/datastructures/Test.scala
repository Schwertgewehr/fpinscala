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

}
