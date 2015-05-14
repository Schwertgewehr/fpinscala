package fpinscala.datastructures

import scala.annotation.tailrec

sealed trait MyList[+A] // `List` data type, parameterized on a type, `A`
case object Nil extends MyList[Nothing] // A `List` data constructor representing the empty list
/* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
which may be `Nil` or another `Cons`.
 */
case class ::[+A](head: A, tail: MyList[A]) extends MyList[A] {
  override def toString: String = s"$head,$tail"
}

object MyList { // `List` companion object. Contains functions for creating and working with lists.
  def sum(ints: MyList[Int]): Int = ints match { // A function that uses pattern matching to add up a list of integers
    case Nil => 0 // The sum of the empty list is 0.
    case ::(x,xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
  }

  def product(ds: MyList[Double]): Double = ds match {
    case Nil => 1.0
    case ::(0.0, _) => 0.0
    case ::(x,xs) => x * product(xs)
  }

  def apply[A](as: A*): MyList[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else ::(as.head, apply(as.tail: _*))

  val casex = MyList(1,2,3,4,5) match {
    case ::(x, ::(2, ::(4, _))) => x
    case Nil => 42
    case ::(x, ::(y, ::(3, ::(4, _)))) => x + y
    case ::(h, t) => h + sum(t)
    case _ => 101
  }

  def append[A](a1: MyList[A], a2: MyList[A]): MyList[A] =
    a1 match {
      case Nil => a2
      case ::(h,t) => ::(h, append(t, a2))
    }

  def foldRight[A,B](as: MyList[A], z: B)(f: (A, B) => B): B = // Utility functions
    as match {
      case Nil => z
      case ::(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def sum2(ns: MyList[Int]) =
    foldRight(ns, 0)((x,y) => x + y)

  def product2(ns: MyList[Double]) =
    foldRight(ns, 1.0)(_ * _) // `_ * _` is more concise notation for `(x,y) => x * y`; see sidebar


  // ex02
  def tail[A](l: MyList[A]): MyList[A] = l match {
    case Nil => throw new NoSuchElementException
    case _ :: xs => xs
  }

  def tailOption[A](l: MyList[A]): Option[MyList[A]] = l match {
    case Nil => None
    case _ :: xs => Some(xs)
  }

  // ex03
  def setHead[A](l: MyList[A], h: A): MyList[A] = l match {
    case _ :: xs => ::(h, xs)
    case _ => ::(h, Nil)
  }

  // ex04
  @tailrec
  def drop[A](l: MyList[A], n: Int): MyList[A] = l match {
    case _ :: xs if n > 0 => drop(xs, n - 1)
    case _ => l
  }

  // ex05
  @tailrec
  def dropWhile[A](l: MyList[A])(f: A => Boolean): MyList[A] = l match {
    case x :: xs if f(x) => dropWhile(xs)(f)
    case _ => l
  }

  // ex06 FIXME not tailrec
  def init[A](l: MyList[A]): MyList[A] = l match {
    case x :: xs => ::(x, init(xs))
    case _ => Nil
  }

  def length[A](l: MyList[A]): Int = sys.error("todo")

  // ex10
  @tailrec
  def foldLeft[A,B](l: MyList[A], z: B)(f: (B, A) => B): B = l match {
    case Nil => z
    case x :: xs => foldLeft(xs, f(z, x))(f)
  }

  //ex11
  def sum3(ints: MyList[Int]): Int = foldLeft(ints, 0)(_ + _)

  def product3(ds: MyList[Double]): Double = foldLeft(ds, 1.0)(_ * _)

  // ex18
  def map[A,B](l: MyList[A])(f: A => B): MyList[B] = {
    foldRight(l, Nil: MyList[B])((a: A, acc: MyList[B]) => ::(f(a), acc))
  }
}
