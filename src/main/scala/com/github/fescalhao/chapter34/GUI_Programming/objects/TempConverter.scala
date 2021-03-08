package com.github.fescalhao.chapter34.GUI_Programming.objects

import scala.swing.event.EditDone
import scala.swing.{FlowPanel, Frame, Label, MainFrame, SimpleSwingApplication, Swing}

object TempConverter extends SimpleSwingApplication {
  override def top: Frame = new MainFrame() {
    title = "Celsius/Fahrenheit Converter"
    contents = new FlowPanel() {
      contents += Celsius
      contents += new Label(" Celsius = ")
      contents += Fahrenheit
      contents += new Label(" Fahrenheit")
      border = Swing.EmptyBorder(15, 10, 10, 10)
    }

    listenTo(Celsius, Fahrenheit)

    reactions += {
      case EditDone(`Fahrenheit`) =>
        val f = Fahrenheit.text.toInt
        val c = (f -32) * 5 / 9
        Celsius.text = c.toString
      case EditDone(`Celsius`) =>
        val c = Celsius.text.toInt
        val f = c * 9 / 5 + 32
        Fahrenheit.text = f.toString
    }
  }
}
