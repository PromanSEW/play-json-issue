name := "play_json_issue"
version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayMinimalJava, PlayEbean)

scalaVersion := "2.12.12"

libraryDependencies ++= Seq(evolutions, javaJdbc, guice)
libraryDependencies += "com.h2database" % "h2" % "1.4.200"

dependencyOverrides ++= Seq(
  "io.ebean" % "ebean" % "12.5.1"
)

unmanagedSourceDirectories in Test += baseDirectory.value / "tests"
