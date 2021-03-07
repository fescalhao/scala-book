package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.classes.abs

abstract class Food(val name: String, val category: String) {
  override def toString: String = name
}
