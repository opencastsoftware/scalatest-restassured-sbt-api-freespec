name := "scalatest-restassured-sbt-api"

version := "0.1"

scalaVersion := "2.13.12"

libraryDependencies ++= AppDependencies.compile ++ AppDependencies.test

//libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-o", "-u", "target/test-reports", "-h", "target/test-reports/htmlReport")

//Compile / unmanagedResourceDirectories += baseDirectory.value / "resources"

//libraryDependencies += "com.geirsson" %% "funsuite" % "0.1.4"

/*javaOptions ++= Seq(
  "-Djdk.xml.maxOccurLimit=10000"
)*/

Test / parallelExecution := sys.props.get("parallelExecution").contains("true")

/*Test / parallelExecution := sys.props.get("parallelExecution").contains("true")
Test / fork := true*/
// Adapted from https://stackoverflow.com/a/31619460 to pass through System Properties
/*
Test / javaOptions ++= {
  val props = System.getProperties
  props.stringPropertyNames().asScala.toList.map { configKey =>
    s"-D$configKey=${props.getProperty(configKey)}"
  }}*/
