package com.github.fescalhao.chapter12.traits

import com.github.fescalhao.chapter12.classes.abs.IntQueue

trait Filtering extends IntQueue {
  abstract override def put(i: Int): Unit = { if (i >= 0) super.put(i) }
}
