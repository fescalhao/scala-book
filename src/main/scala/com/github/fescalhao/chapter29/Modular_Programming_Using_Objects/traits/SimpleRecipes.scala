package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.traits

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.recipe.FruitSalad

trait SimpleRecipes {
  this: SimpleIngredients =>

  def allRecipes = List(FruitSalad)
}
