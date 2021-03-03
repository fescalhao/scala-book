package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl.Recipe
import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.traits.FoodCategories

abstract class Database extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]

  def foodName(name: String): Option[Food] = {
    allFoods.find(_.name == name)
  }
}
