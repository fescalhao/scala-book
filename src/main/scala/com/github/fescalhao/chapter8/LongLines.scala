//Functions and Closures

package com.github.fescalhao.chapter8

import scala.io.Source

object LongLines extends App {

  val filename: String = "./src/scripts/read_file.scala"
  val lines: Iterator[String] = processFile(filename, 20)
  println(lines.mkString("\n"))

  def processFile(filename: String, width: Int): Iterator[String] = {

    def processLine(line: String): String = {
      s"$filename: ${line.trim}"
    }

    val source = Source.fromFile(filename)
    for {line <- source.getLines() if line.length > width} yield {processLine(line)}
  }
}
