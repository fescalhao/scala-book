// Control Abstraction

package com.github.fescalhao.chapter9.Control_Abstraction

import java.io.{File, PrintWriter}
import java.util.Date

object CurlyPrintWriter extends App {

  val file = new File("date.txt")
  withPrintWriter(file) {
    writer => writer.println(new Date())
  }

  def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
}
