package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.mock.database

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.classes.abs.Database
import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.traits.{StudentIngredients, StudentRecipes}

object StudentDatabase extends Database
  with StudentIngredients
  with StudentRecipes {

  override def allCategories: List[FoodCategory] = List(
    FoodCategory("Frozen", allFoods.filter(_.category == "Frozen"))
  )
}
