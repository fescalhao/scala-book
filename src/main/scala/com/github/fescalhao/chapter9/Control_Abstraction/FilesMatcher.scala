// Control Abstraction

package com.github.fescalhao.chapter9.Control_Abstraction

import java.io.File

object FilesMatcher extends App {
  val location = "./src/main/scala/com/github/fescalhao/chapter8"
  val files: Array[File] = filesContaining("Function")

  val fileNames: Array[String] =
    for (file <- files) yield {
      file.getName.split("/").last
    }

  println(fileNames.mkString("\n"))

  private def filesHere(location: String): Array[File] = {
    new File(location).listFiles()
  }

  def filesMatching(matcher: String => Boolean): Array[File] = {
    for (file <- filesHere(location); if matcher(file.getName))
      yield file
  }

  def filesEnding(query: String): Array[File] = {
    filesMatching(_.endsWith(query))
  }

  def filesContaining(query: String): Array[File] = {
    filesMatching(_.contains(query))
  }

  def filesRegex(query: String): Array[File] = {
    filesMatching(_.matches(query))
  }
}
