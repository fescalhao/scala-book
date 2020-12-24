package com.github.fescalhao.chapter23.For_Expressions_Revisited.objects

object Demo {
  def myMap[A, B](xs: List[A], f: A => B): List[B] = {
    for {
      x <- xs
    } yield f(x)
  }

  def nyFlatMap[A, B](xs: List[A], f: A => List[B]): List[B] = {
    for {
     x <- xs
     y <- f(x)
    } yield y
  }

  def myFilter[A](xs: List[A], f: A => Boolean): List[A] = {
    for {
      x <- xs
      if f(x)
    } yield x
  }
}
