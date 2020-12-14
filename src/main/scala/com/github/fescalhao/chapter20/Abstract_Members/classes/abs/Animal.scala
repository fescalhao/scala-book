package com.github.fescalhao.chapter20.Abstract_Members.classes.abs

abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood): Unit
}
