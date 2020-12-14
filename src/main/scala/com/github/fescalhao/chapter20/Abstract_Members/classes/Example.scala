package com.github.fescalhao.chapter20.Abstract_Members.classes

import com.github.fescalhao.chapter20.Abstract_Members.objects.Demo
import com.github.fescalhao.chapter20.Abstract_Members.traits.RationalTrait

class Example {

  def executeExamples(): Unit = {
    println("------------------------------ Abstract Example ------------------------------")
    abstractExample()
    println("----------------------------- Pre-initialization -----------------------------")
    preInitialization()
    println("-------------------------------- Lazy Example --------------------------------")
    lazyExample()
    println("------------------------------- Abstract Types -------------------------------")
    abstractTypes()
  }

  private def abstractExample(): Unit = {
    val concrete = new Concrete(2)
    println(concrete.current)
    println(concrete.transform(5))
    println(concrete.current)
  }

  private def preInitialization(): Unit = {
    val x = 2
    val rat = new {
      val numerArg: Int = 1 * x
      val denomArg: Int = 2 * x
    } with RationalTrait
    println(rat.numer)
  }

  private def lazyExample(): Unit = {
    val rat1 = new Rational(15, 3)
    val rat2 = new Rational(12, 7)
    println(rat1 + rat2)

    val d1 = Demo
    val d2 = Demo

    println(d1)
    println(d1.x)
    println(d2.y)
  }

  private def abstractTypes(): Unit = {
    val cow = new Cow
    cow.eat(new Grass)

    val pasture = new Pasture
    pasture.addGrassAnimal(cow)
    println(pasture.grassAnimals)
  }
}
