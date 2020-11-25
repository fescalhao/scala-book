// Assertions and Tests

package com.github.fescalhao.chapter14.classes.test

import org.scalatest.funsuite.AnyFunSuite
import com.github.fescalhao.chapter10.impl.ElementFactory.elem

/*
  AnyFunSuite is available here because of the way "org.scalatest" was add as a project dependency on the file build.sbt:
    - libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2"

  Another way to add this dependency is:
    - libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"

  Adding the dependency as above would restrict the use of "org.scalatest" only to the directory marked as a test directory.
  The directory path is /scr/test/scala
*/

class ElementSuite extends AnyFunSuite {
  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 3)
  }
}
