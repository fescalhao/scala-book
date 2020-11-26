// Traits

package com.github.fescalhao.chapter12

import com.github.fescalhao.chapter12.classes.{BasicIntQueue, Frog, MyQueue, Point, Rational, Rectangle}
import com.github.fescalhao.chapter12.traits.{Filtering, Incrementing, Philosophical}

object Application extends App {
  val frog = new Frog
  println(frog)
  frog.philosophise()
  println("-------------")

  val phil: Philosophical = frog
  phil.philosophise()
  println("-------------")

  val rect: Rectangle = new Rectangle(new Point(3, 5), new Point(7, 2))
  println(rect)
  println()
  println(s"Rectangle's width is ${rect.width}")
  println(s"Rectangle's height is ${rect.height}")
  println("-------------")

  val rat1 = new Rational(3, 5)
  val rat2 = new Rational(5, 9)
  println(rat1 > rat2)
  println("-------------")

  val basicIntQueue = new BasicIntQueue
  basicIntQueue.put(10)
  basicIntQueue.put(53)
  basicIntQueue.put(12)
  println(basicIntQueue)
  println(s"${basicIntQueue.get()} was removed from the Array")
  println(basicIntQueue)
  println("-------------")

  val myQueue = new MyQueue // new BasicIntQueue with Doubling works the same way
  myQueue.put(10)
  myQueue.put(4)
  myQueue.put(12)
  println(myQueue)
  println(s"${myQueue.get()} was removed from the Array")
  println(myQueue)
  println("-------------")

  // The order of traits matter -> Incrementing is executed before Filtering
  val anotherQueue = new BasicIntQueue with Filtering with Incrementing
  anotherQueue.put(-1)
  anotherQueue.put(-7)
  anotherQueue.put(19)
  println(anotherQueue)
  println(s"${anotherQueue.get()} was removed from the Array")
  println(anotherQueue)
  println("-------------")

  val anotherQueueOrder = new BasicIntQueue with Incrementing with Filtering
  anotherQueueOrder.put(-1)
  anotherQueueOrder.put(-7)
  anotherQueueOrder.put(19)
  println(anotherQueueOrder)
  println(s"${anotherQueueOrder.get()} was removed from the Array")
  println(anotherQueueOrder)
  println("-------------")
}
