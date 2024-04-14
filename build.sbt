ThisBuild / organization := "io.github.kincsescsaba"

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.1"

lazy val root = (project in file("."))
  .settings(
    name := "dotty-test-classpath-problem",
    libraryDependencies ++= Seq(
      "org.scala-lang" %% "scala3-compiler" % scalaVersion.value,
      "org.scalatest" %% "scalatest" % "3.2.18" % Test
    ),
    resolvers += Resolver.mavenLocal
  )
