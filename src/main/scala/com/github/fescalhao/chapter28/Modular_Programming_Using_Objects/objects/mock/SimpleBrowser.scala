package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.mock

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Food
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.Recipe
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl.Recipe

object SimpleBrowser {
  def recipesUsing(food: Food): List[Recipe] = {
    SimpleDatabase.allRecipes.filter(recipe =>
    recipe.ingredients.contains(food))
  }

  def displayCategoryFood(categoryName: String): Option[List[Food]] = {
    val category = SimpleDatabase.allCategories.filter(category => category.name == categoryName)
    if (category.nonEmpty)
      Some(category.head.foods)
    else
      None
  }
}
