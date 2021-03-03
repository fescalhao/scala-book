package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.mock.database

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.{Database, Food}
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl.Recipe
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.ingredient.FrozenFood
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.objects.recipe.HeatItUp

object StudentDatabase extends Database {
  override def allFoods: List[Food] = List(FrozenFood)

  override def allRecipes: List[Recipe] = List(HeatItUp)

  override def allCategories: List[FoodCategory] = List(
    FoodCategory("Frozen", allFoods.filter(_.category == "Frozen"))
  )
}
