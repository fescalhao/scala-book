package com.github.fescalhao.chapter18.Mutable_Objects.classes

class Example {
  def executeExample(): Unit = {
    println("----------------------------------- Time ------------------------------------")
    time()
    println("-------------------------------- Thermometer --------------------------------")
    thermometer()
  }

  def time(): Unit = {
    val time1 = new TimeGetterSetterImplicit
    time1.hour = 10
    time1.minute = 15

    val time2 = new TimeGetterSetterExplicit
    time2.hour = 18
    time2.minute = 10

    val time3 = new TimeMyGetterSetter
    time3.hour = 17
    time3.minute = 45

    println(s"TimeGetterSetterImplicit -> ${time1.hour}:${time1.minute}")
    println(s"TimeGetterSetterExplicit -> ${time2.hour}:${time2.minute}")
    println(s"TimeMyGetterSetter -> ${time3.hour}:${time3.minute}")
  }

  def thermometer(): Unit = {
    val thermometer = new Thermometer
    println(s"Initial temperature: $thermometer")

    thermometer.celsius = 40
    println(s"Celsius to 40: $thermometer")

    println(s"Fahrenheit: ${thermometer.fahrenheit}")

    thermometer.fahrenheit = 12
    println(s"thermometer.fahrenheit set to 12: $thermometer")

  }
}
