package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.traits

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.ingredient.{Apple, Orange, Pear, Sugar}

trait SimpleIngredients extends FoodCategories {
  def allFoods = List(Apple, Pear, Orange, Sugar)
  def allCategories: List[FoodCategory]
}
