Nice.scalaProject

name := "samtools"
organization := "ohnosequences-bundles"
description := "A bundle for samtools tool"

publishBucketSuffix := "era7.com"

resolvers ++= Seq(
  "Era7 public maven releases"  at s3("releases.era7.com").toHttps(s3region.value.toString),
  "Era7 public maven snapshots" at s3("snapshots.era7.com").toHttps(s3region.value.toString)
)

libraryDependencies ++= Seq(
	"ohnosequences"             %% "statika"          % "2.0.0-SNAPSHOT",
	"ohnosequences-bundles"     %% "compressinglibs"  % "0.1.0",
	"ohnosequences-bundles"     %% "cdevel"           % "0.1.0",
	"ohnosequences-bundles"     %% "ncurses"          % "0.1.0"
)
