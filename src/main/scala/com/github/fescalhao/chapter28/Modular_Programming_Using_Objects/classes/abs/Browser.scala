package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl.Recipe

abstract class Browser {
  val database: Database

  def recipesUsing(food: Food): List[Recipe] = {
    database.allRecipes.filter(recipe => recipe.ingredients.contains(food))
  }

  def displayCategoryFood(categoryName: String): Option[List[Food]] = {
    val category = database.allCategories.filter(category => category.name == categoryName)
    if (category.nonEmpty)
      Some(category.head.foods)
    else
      None
  }
}
