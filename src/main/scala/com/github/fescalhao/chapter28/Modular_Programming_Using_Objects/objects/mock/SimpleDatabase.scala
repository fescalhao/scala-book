package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.mock

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Food
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.Recipe
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl.{FoodCategory, Recipe}
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.ingredient._
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.recipe.FruitSalad

object SimpleDatabase {
  def allFoods = List(Apple, Orange, Cream, Sugar)

  def foodName(name: String): Option[Food] = {
    allFoods.find(_.name == name)
  }

  def allRecipes: List[Recipe] = List(FruitSalad)

  private val categories: List[FoodCategory] = List(
    FoodCategory("Fruit", allFoods.filter(_.category == "Fruit")),
    FoodCategory("Misc", allFoods.filter(_.category == "Misc"))
  )

  def allCategories: List[FoodCategory] = categories
}
