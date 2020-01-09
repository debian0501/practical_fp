import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "de.maibornwolff"
ThisBuild / organizationName := "practicalfp"

lazy val root = (project in file("."))
  .settings(
    name := "practical_fp",
    libraryDependencies ++= Seq(
      compilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full),
      "org.typelevel"  %% "cats-core"    % "2.0.0",
      "org.typelevel"  %% "squants"      % "1.6.0", 
      "org.typelevel"  %% "cats-effect"  % "2.0.0",
      "dev.profunktor" %% "console4cats" % "0.8.0",
      "io.estatico"    %% "newtype"      % "0.4.3",
      "eu.timepit"     %% "refined"      % "0.9.10",
      "dev.profunktor" %% "http4s-jwt-auth" % "0.0.3",
      "com.github.cb372" %% "cats-retry" % "1.0.0",
      "io.chrisdavenport" %% "log4cats-slf4j" % "1.0.1"
    )
  )
  scalacOptions ++= Seq(
    "-Ymacro-annotations"
)
    

