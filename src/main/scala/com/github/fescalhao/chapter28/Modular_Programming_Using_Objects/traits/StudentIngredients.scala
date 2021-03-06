package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.traits

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.ingredient.FrozenFood

trait StudentIngredients extends FoodCategories {
  def allFoods = List(FrozenFood)
  def allCategories: List[FoodCategory]
}
