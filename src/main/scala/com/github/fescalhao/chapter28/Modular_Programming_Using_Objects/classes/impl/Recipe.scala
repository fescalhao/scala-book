package com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.impl

import com.github.fescalhao.chapter28.Modular_Programming_Using_Objects.classes.abs.Food

class Recipe(
              val name: String,
              val ingredients: List[Food],
              val instructions: String
            ) {
  override def toString: String = name
}
