ThisBuild / scalaVersion := "2.13.13"
ThisBuild / organization := "com.github.fescalhao"

lazy val hello = (project in file("."))
  .settings(
    name := "scala-book",
    libraryDependencies ++= List(
      "org.scalatest" %% "scalatest" % "3.2.19",
      "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0",
      "org.scala-lang.modules" %% "scala-parser-combinators" % "2.4.0",
      "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
    )
  )