package com.github.fescalhao.chapter34.GUI_Programming.objects

import scala.swing.event.ButtonClicked
import scala.swing.{BoxPanel, Button, Frame, Label, MainFrame, Orientation, SimpleSwingApplication, Swing}

object SecondSwingApp extends SimpleSwingApplication {
  override def top: Frame = new MainFrame() {
    title = "Second Swing App"

    val button = new Button() {
      text = "Click me!"
    }
    val label = new Label() {
      text = "No button clicks registered"
    }

    contents = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }

    listenTo(button)

    var nClicks = 0
    reactions += {
      case ButtonClicked(b) =>
        nClicks += 1
        label.text = s"Number of button clocks: $nClicks"
    }
  }
}
