// Control Abstraction

package com.github.fescalhao.chapter9.Control_Abstraction

object ByParameters extends App {

  // predicate: Boolean evaluates the expression before passing it to myAssert: 5 / 0 == 0 = true -> myAssert(true)...
  // predicate: => Boolean creates a function value: func(5 / 0 == 0) -> myAssert(func)...

  // predicate: Boolean throws an ArithmeticException whereas predicate: => Boolean does not!

  val assertion = false

  def myAssert(predicate: => Boolean): Unit = {
    if(assertion && !predicate)
      throw new AssertionError
  }

  myAssert(5 / 0 == 0)
}
