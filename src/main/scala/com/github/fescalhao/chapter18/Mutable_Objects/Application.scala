package com.github.fescalhao.chapter18.Mutable_Objects

import com.github.fescalhao.chapter18.Mutable_Objects.classes.Example
import MySimulation._

object Application extends App {
  val example = new Example
  example.executeExample()

  println("----------------------------------- Circuit Simulation -----------------------------------")

  val input1, input2, sum, carry = new Wire
  probe("sum", sum)
  probe("carry", carry)

  halfAdder(input1, input2, sum, carry)

  input1 setSignal true
  run()

  input2 setSignal true
  run()
}
