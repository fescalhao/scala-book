// Classes and Operators

package com.github.fescalhao.chapter4.Classes_And_Operators

import ChecksumAccumulator.calculate

object Application {
  def main(args: Array[String]): Unit = {
    for(arg <- args) {
      println(arg + ": " + calculate(arg))
    }
  }
}
