// Classes and Operators

package com.github.fescalhao.chapter4.Classes_And_Operators

import scala.collection.mutable

class ChecksumAccumulator {
  private var sum = 0

  def add(num: Byte): Unit = {
    // num is a val not a var
    sum += num
  }

  def checksum(): Int = {
    ~(sum & 0xFF) + 1
  }
}

object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if(cache.contains(s)) {
      cache(s)
    } else {
      val acc = new ChecksumAccumulator
      for(c <- s) {
        acc.add(c.toByte)
      }

      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  }
}

