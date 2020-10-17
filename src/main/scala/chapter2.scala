object chapter2 extends App {

  println(max(4,6))

// ------------------------------- Val/Var -------------------------------
  def val_var = {
    // You can't reassign val variables
    val msg = "Hello World"
    println(msg)
    //  msg = "Again" produces an error

    // You can reassign var variables
    var msg2 = "WoW"
    msg2 = "Such programming!"
    println(msg2)
  }
// ------------------------------------------------------------------------

// ------------------------------- Function -------------------------------
  // Parameter type is required
  def max(x: Int, y: Int): Int = {
    if(x>y) x else y
  }

  // Scala's Unit type corresponds to Void type in Java
  def greet() = {
    println("Hello")
  }
}
// ------------------------------------------------------------------------

