package com.github.fescalhao.chapter12.traits

import com.github.fescalhao.chapter12.classes.abs.IntQueue

trait Doubling extends IntQueue {
  abstract override def put(i: Int): Unit = { super.put(2 * i) }
}
