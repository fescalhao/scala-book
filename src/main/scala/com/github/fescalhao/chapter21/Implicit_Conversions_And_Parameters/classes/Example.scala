package com.github.fescalhao.chapter21.Implicit_Conversions_And_Parameters.classes

import com.github.fescalhao.chapter21.Implicit_Conversions_And_Parameters.objects.Greet
import com.github.fescalhao.chapter6.Functional_Objects.Rational
import com.github.fescalhao.chapter21.Implicit_Conversions_And_Parameters.objects.MyPredefImplicit._

import java.awt.event.ActionEvent
import javax.swing.JButton

class Example {

  def executeExamples(): Unit = {
    println("--------------------------- Implicit Conversions ---------------------------")
    implicitConversions()
    println("-------------------- Implicit Conversions - Expect Type --------------------")
    implicitConversionExpectType()
    println("-------------------- Implicit Conversions - To Receiver --------------------")
    implicitConversionToReceiver()
    println("---------------------------- Implicit Perameters ---------------------------")
    implicitParameters()
  }

  def implicitConversions(): Unit = {
    var x = 2
    val button = new JButton
    button.addActionListener(
      (_: ActionEvent) => {
        x = x * 3
        println(s"x multiplied by 3 = $x")
      }
    )
    button.doClick()
  }

  def implicitConversionExpectType(): Unit = {
    val i: Int = 3.5
    println(i)
  }

  def implicitConversionToReceiver(): Unit = {
    val rat1 = new Rational(1, 2)
    println(rat1)
    println(rat1 + rat1)
    println(rat1 + 1)
    println(1 + rat1) // int2Rational converts 1 to 1/1

    // implicit classes
    val myRectangle = 3 x 4
    println(myRectangle)
  }

  def implicitParameters(): Unit = {

    // [T: Ordering] is a Context Bound
    def maxListOrdering[T: Ordering](elements: List[T]): T = {
      elements match {
        case List() => throw new IllegalArgumentException("Empty List!")
        case List(x) => x
        case x :: tailElems =>
          val maxRest = maxListOrdering(tailElems) // (ordering) is implicit
          if (implicitly[Ordering[T]].gt(x, maxRest)) x // "if (ordering.gt(x, maxRest)) x" works as well!
          else maxRest
      }
    }

    val myIntList: List[Int] = List(2, 7, 45, 12, 3, 54, 71, 4, 8)
    Greet.greet("Felipe")
    val maxInt = maxListOrdering(myIntList)

    println(s"Max value from $myIntList is $maxInt")
  }

}
