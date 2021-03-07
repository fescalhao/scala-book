package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.traits

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.recipe.HeatItUp

trait StudentRecipes {
  this: StudentIngredients =>

  def allRecipes = List(HeatItUp)
}
