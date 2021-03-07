package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.mock.database

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.classes.abs.Database
import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.traits.{SimpleIngredients, SimpleRecipes}

object SimpleDatabase extends Database
  with SimpleIngredients
  with SimpleRecipes {

  override def allCategories: List[FoodCategory] = List(
    FoodCategory("Fruit", allFoods.filter(_.category == "Fruit")),
    FoodCategory("Misc", allFoods.filter(_.category == "Misc"))
  )
}
