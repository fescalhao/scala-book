package com.github.fescalhao.chapter20.Abstract_Members.classes

import com.github.fescalhao.chapter20.Abstract_Members.classes.abs.Animal

class Cow extends Animal {
  override type SuitableFood = Grass
  override def eat(food: SuitableFood): Unit = {
    println(s"The cow is eating $food")
  }

  override def toString: String = "I'm a Cow!"
}
