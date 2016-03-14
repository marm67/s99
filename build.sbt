/** Project */
name := "s99"

version := "1.0"

// scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2-core" % "3.7.2" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

// scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions")
