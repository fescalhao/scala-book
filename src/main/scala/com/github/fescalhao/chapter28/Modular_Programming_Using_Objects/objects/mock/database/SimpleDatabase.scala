package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.mock.database

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Database
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl.Recipe
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.ingredient._
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.recipe.FruitSalad
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.traits.FoodCategories

object SimpleDatabase extends Database with FoodCategories {
  def allFoods = List(Apple, Orange, Cream, Sugar)

  def allRecipes: List[Recipe] = List(FruitSalad)

  private val categories: List[FoodCategory] = List(
    FoodCategory("Fruit", allFoods.filter(_.category == "Fruit")),
    FoodCategory("Misc", allFoods.filter(_.category == "Misc"))
  )

  def allCategories: List[FoodCategory] = categories
}
