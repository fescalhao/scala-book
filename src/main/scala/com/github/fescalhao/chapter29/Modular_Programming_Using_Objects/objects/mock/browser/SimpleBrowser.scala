package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.mock.browser

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.classes.abs.{Browser, Database}
import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.mock.database.SimpleDatabase

object SimpleBrowser extends Browser {
  override val database: Database = SimpleDatabase
}
