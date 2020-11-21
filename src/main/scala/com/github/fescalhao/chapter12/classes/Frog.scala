// Traits

package com.github.fescalhao.chapter12.classes

import com.github.fescalhao.chapter12.traits.{HasLegs, Philosophical}

class Frog extends Animal with Philosophical with HasLegs{
  override def toString: String = "green"

  override def philosophise(): Unit = {
    println(s"It's not easy being $toString")
  }
}
