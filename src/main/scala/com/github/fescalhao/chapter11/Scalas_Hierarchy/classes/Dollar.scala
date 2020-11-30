// Scala's Hierarchy

package com.github.fescalhao.chapter11.Scalas_Hierarchy.classes

class Dollar(val amount: Double) extends AnyVal {
  override def toString: String = "$" + amount
}
