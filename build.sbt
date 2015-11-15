name := "camel-getting-started"

version := "1.0"

scalaVersion := "2.11.7"

val vCamel = "2.16.0"
val vSlf4j = "1.7.12"
val vScalaTest = "2.2.1"


libraryDependencies ++= Seq(
  "org.apache.camel" % "camel-core" % vCamel,
  "org.apache.camel" % "camel-scala" % vCamel,
  "org.apache.camel" % "camel-spring" % vCamel,

  "org.slf4j" % "slf4j-api" % vSlf4j,
  "org.slf4j" % "slf4j-log4j12" % vSlf4j,
  "org.apache.logging.log4j" % "log4j-core" % "2.4.1",

  "org.scalatest" %% "scalatest" % vScalaTest % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test"

)
