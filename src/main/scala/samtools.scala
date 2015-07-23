package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._


abstract class Samtools(val samtoolsVersion: String) extends Bundle(cdevel, compressinglibs, ncurses) {

  import ammonite.ops._

  val samtoolsDir     = s"samtools-${samtoolsVersion}"
  val samtoolsBinary  = samtoolsDir/"samtools"
  val bin             = root/"usr"/"bin"

  final def install: Results = {

    val wd = cwd

    Seq("wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/samtools/${samtoolsVersion}/${samtoolsDir}.tar.bz2") ->-
    Seq("tar", "--bzip2", "-xf", s"${samtoolsDir}.tar.bz2") ->-
    Seq("make", "-C", (wd/samtoolsDir).toString) ->- {

      cp(wd/samtoolsBinary, bin/"samtools")
      success(s"${bundleName} is installed")
    }
  }
}
