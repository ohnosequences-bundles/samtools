package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._


abstract class Samtools(val samtoolsVersion: String) extends Bundle(cdevel, compressinglibs, ncurses) {

  val samtoolsDir = s"samtools-${samtoolsVersion}"

  final def install: Results = {

    Seq("wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/samtools/${samtoolsVersion}/${samtoolsDir}.tar.bz2") -&-
    Seq("tar", "--bzip2", "-xf", s"${samtoolsDir}.tar.bz2") -&-
    Seq("make", "-C", samtoolsDir) -&-
    Seq("cp", s"${samtoolsDir}/samtoolsBinary", "/usr/bin/samtools") ->-
    success(s"${bundleName} is installed")
  }
}