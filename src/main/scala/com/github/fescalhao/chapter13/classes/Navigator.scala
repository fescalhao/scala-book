// Packages and Imports

package com.github.fescalhao.chapter13

package bobsrocket {

  package navigation {
    class StarMap

    class Navigator {
      val map = new StarMap
    }
  }

  class Ship {
    val nav = new navigation.Navigator
  }

  package fleet {
    class Fleet {
      def addShip() = { new Ship }
    }
  }
}

