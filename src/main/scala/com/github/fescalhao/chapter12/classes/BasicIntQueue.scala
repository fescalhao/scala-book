package com.github.fescalhao.chapter12.classes

import com.github.fescalhao.chapter12.classes.abs.IntQueue

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()

  override def get(): Int = buf.remove(0)

  override def put(i: Int): Unit = buf append i

  override def toString: String = buf.mkString(", ")
}
