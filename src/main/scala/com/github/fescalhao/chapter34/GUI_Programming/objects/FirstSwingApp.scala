package com.github.fescalhao.chapter34.GUI_Programming.objects

import scala.swing.{Button, Frame, MainFrame, SimpleSwingApplication}


object FirstSwingApp extends SimpleSwingApplication {
  override def top: Frame = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me!"
    }
  }
}
