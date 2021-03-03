package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Food

case class FoodCategory(name: String, foods: List[Food]) {
  override def toString: String = name
}
