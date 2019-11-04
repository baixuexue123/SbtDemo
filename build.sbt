ThisBuild / scalaVersion := "2.12.10"
ThisBuild / organization := "com.example"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val gigahorse = "com.eed3si9n" %% "gigahorse-okhttp" % "0.3.1"
val playJson  = "com.typesafe.play" %% "play-json" % "2.6.9"

lazy val hello = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest % Test,
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest % Test,
  )

lazy val SimpleApp = (project in file("SimpleApp"))
  .settings(
    name := "Simple App",
    version := "0.1",
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4",
  )

lazy val wordcount = (project in file("wordcount"))
  .settings(
    name := "word count network",
    version := "0.1",
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4",
  )
