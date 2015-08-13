Nice.scalaProject

name := "samtools"
organization := "ohnosequencesBundles"
description := "A bundle for samtools tool"

publishBucketSuffix := "era7.com"

resolvers ++= Seq(
  "Era7 public maven releases"  at s3("releases.era7.com").toHttps(s3region.value.toString),
  "Era7 public maven snapshots" at s3("snapshots.era7.com").toHttps(s3region.value.toString)
)

libraryDependencies ++= Seq(
	"ohnosequences" %% "statika" % "2.0.0-SNAPSHOT",
	"ohnosequencesBundles" %% "compressinglibs" % "0.1.0",
	"ohnosequencesBundles" %% "cdevel" % "0.1.0-SNAPSHOT",
	"ohnosequencesBundles" %% "ncurses" % "0.1.0-SNAPSHOT",
  "com.lihaoyi"   %% "ammonite-ops" % "0.2.7"
)
