// Packages and Imports

package com.github.fescalhao.chapter13.Packages_And_Imports.classes

abstract class Fruit (
  val name: String,
  val color: String
) {
  override def toString: String = s"Fruit $name has color $color"
}

object Fruits {
  object Orange extends Fruit("Orange", "orange")
  object Apple extends Fruit("Apple", "red")
  object Pear extends Fruit("Pear", "yellowish")
  val menu = List(Orange, Apple, Pear)
}