package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.traits

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Food

trait FoodCategories {
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}
