package com.github.fescalhao.chapter20.Abstract_Members.classes

import com.github.fescalhao.chapter20.Abstract_Members.classes.abs.Animal

class Pasture {
  var grassAnimals: List[Animal { type SuitableFood = Grass}] = Nil

  def addGrassAnimal[T](animal: Animal { type SuitableFood = Grass}): Unit = {
    grassAnimals = grassAnimals :+ animal
  }

  override def toString: String = s"${grassAnimals}"
}
