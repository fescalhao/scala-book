// Scala's Hierarchy

package com.github.fescalhao.chapter11.classes

class Dollar(val amount: Double) extends AnyVal {
  override def toString: String = "$" + amount
}
