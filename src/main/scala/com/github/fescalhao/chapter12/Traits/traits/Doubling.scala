package com.github.fescalhao.chapter12.Traits.traits

import com.github.fescalhao.chapter12.Traits.classes.abs.IntQueue

trait Doubling extends IntQueue {
  abstract override def put(i: Int): Unit = { super.put(2 * i) }
}
