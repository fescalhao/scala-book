// Classes and Operators

package com.github.fescalhao.chapter4.Classes_And_Operators

import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {
  for(season <- List("fall", "winter", "spring", "summer")) {
    println(season + ": " + calculate(season))
  }
}
