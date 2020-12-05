package com.github.fescalhao.chapter18.Mutable_Objects

import com.github.fescalhao.chapter18.Mutable_Objects.classes.abs.CircuitSimulation

object MySimulation extends CircuitSimulation {
  override def InverterDelay: Int = 1
  override def AndGateDelay: Int = 3
  override def OrGateDelay: Int = 5
}
