package com.github.fescalhao.chapter12.Traits.traits

import com.github.fescalhao.chapter12.Traits.classes.abs.IntQueue

trait Filtering extends IntQueue {
  abstract override def put(i: Int): Unit = { if (i >= 0) super.put(i) }
}
