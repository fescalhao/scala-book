package com.github.fescalhao.chapter21.Implicit_Conversions_And_Parameters.objects

import com.github.fescalhao.chapter21.Implicit_Conversions_And_Parameters.classes.{PreferredDrink, PreferredPrompt, Rectangle}
import com.github.fescalhao.chapter6.Functional_Objects.Rational

import java.awt.event.{ActionEvent, ActionListener}

object MyPredefImplicit {
  implicit val prompt: PreferredPrompt = new PreferredPrompt("Yes, master> ")
  implicit val drink: PreferredDrink = new PreferredDrink("coffee")

  implicit def function2ActionListener(f: ActionEvent => Unit): ActionListener = {
    (event: ActionEvent) => f(event)
  }

  implicit def doubleToInt(d: Double): Int = {
    d.toInt
  }

  implicit def int2Rational(n: Int): Rational = {
    new Rational(n, 1)
  }

  implicit class RectangleMaker(width: Int) {
    def x(height: Int): Rectangle = {
      Rectangle(width, height)
    }
  }

}
