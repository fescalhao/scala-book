package com.github.fescalhao.chapter29.Object_Equality.classes

import com.github.fescalhao.chapter29.Object_Equality.classes.Point.{ColoredPoint, Point_v1, Point_v2, Point_v3, Point_v4}
import com.github.fescalhao.chapter29.Object_Equality.objects.{Color, EmptyTree}

import scala.collection.mutable

class Example {
  def executeExamples(): Unit = {
    println("---------------- Pitfall #1: Defining 'equals' with the wrong signature ----------------")
    pitfall1()
    println("\n------------ Pitfall #2: Changing 'equals' without also changing 'hashCode' ------------")
    pitfall2()
    println("\n--------------- Pitfall #3: Defining 'equals' in terms of mutable fields ---------------")
    pitfall3()
    println("\n----------- Pitfall #4: Failing to define 'equals' as an equivalence relation ----------")
    pitfall4()
    println("\n----------------------- Defining equality for parameterized types ----------------------")
    pitfall4()
  }

  def pitfall1(): Unit = {
    val p1, p2: Point_v1 = new Point_v1(1, 2)
    val p3: Point_v1 = p1
    val q: Point_v1 = new Point_v1(3, 2)
    val col1: mutable.HashSet[Point_v1] = mutable.HashSet(p1)
    val p2a: Any = p2

    println(s"\tp1 equals p2: ${p1 equals p2}")
    println(s"\tp1 eq p2: ${p1 eq p2}")
    println(s"\tp1 == p2: ${p1 == p2}")
    println(s"\tp1 equals p2a: ${p1 equals p2a}")
    println("----------------------------")
    println(s"\tp1 equals p3: ${p1 equals p3}")
    println(s"\tp1 eq p3: ${p1 eq p3}")
    println(s"\tp1 == p3: ${p1 == p3}")
    println("----------------------------")
    println(s"\tp1 equals q: ${p1 equals q}")
    println("----------------------------")
    println(s"\tcol1 contains p2: ${col1 contains p2}")
  }

  def pitfall2(): Unit = {
    val p1, p2: Point_v2 = new Point_v2(1, 2)
    val col2: mutable.HashSet[Point_v2] = mutable.HashSet(p1)
    println(s"\tcol2 contains p2: ${col2 contains p2}")
  }

  def pitfall3(): Unit = {
    val p: Point_v3 = new Point_v3(1, 2)
    val col3: mutable.HashSet[Point_v3] = mutable.HashSet(p)

    println(s"\tcol3 contains p: ${col3 contains p}")
    println(s"\tadding 1 to x in p(x, y): (${p.x}, ${p.y}) => (${p.x += 1; p.x}, ${p.y})")
    println(s"\tcol3 contains p: ${col3 contains p}")
    println(s"\tcol3.iterator contains p: ${col3.iterator contains p}")
  }

  def pitfall4(): Unit = {
    val p: Point_v4 = new Point_v4(3, 4)
    val cp: ColoredPoint = new ColoredPoint(3, 4, Color.Red)
    val cp2: ColoredPoint = new ColoredPoint(3, 4, Color.Blue)
    val pAnon = new Point_v4(3, 3) { override val y = 4 }
    val col4 = List(p)

    println(s"\tp equals cp: ${p equals cp}")
    println(s"\tcp equals p: ${cp equals p}")
    println(s"\tcp equals p: ${cp equals p}")
    println(s"\tp equals cp2: ${p equals cp2}")
    println(s"\tcp equals cp2: ${cp equals cp2}")
    println(s"\tp equals pAnon: ${p equals pAnon}")
    println(s"\tcol4 contains p: ${col4 contains p}")
    println(s"\tcol4 contains cp: ${col4 contains cp}")
    println(s"\tcol4 contains pAnon: ${col4 contains pAnon}")
  }

  def equalParamTyp(): Unit = {
    val b1 = new Branch[List[String]](Nil, EmptyTree, EmptyTree)
    val b2 = new Branch[List[Int]](Nil, EmptyTree, EmptyTree)

    println(s"\tb1 == b2: ${b1 == b2}")
  }
}
