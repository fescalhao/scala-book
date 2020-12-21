package com.github.fescalhao.chapter21.Implicit_Conversions_And_Parameters.objects

import com.github.fescalhao.chapter21.Implicit_Conversions_And_Parameters.classes.{PreferredDrink, PreferredPrompt}

object Greet {
  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink): Unit = {
    println(s"Welcome $name. The system is ready...")
    println(s"While you work, why not enjoy a cup of ${drink.preference}?")
    println(prompt.preference)
  }
}
