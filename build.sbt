val ScalatraVersion = "2.7.0"

organization := "com.calcifer"                                                                                                                  

name := "My Scalatra Web App"                                                                                                                   

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.11"

mainClass in assembly := Some("com.calcifer.server.JettyLauncher")

resolvers += Classpaths.typesafeReleases                                                                                                        

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "org.slf4j" % "slf4j-simple" % "1.7.25",
  "com.typesafe" % "config" % "1.4.0",
  "com.outworkers"  %% "phantom-dsl" % "2.59.0",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)


