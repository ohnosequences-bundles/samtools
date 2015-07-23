package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._


abstract class Samtools(val samtoolsVersion: String) extends Bundle(cdevel, compressinglibs, ncurses) {

  import ammonite.ops._

  val samtoolsDir = s"samtools-${samtoolsVersion}"

  def install: Results = {
    Seq(
      "wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/samtools/${samtoolsVersion}/${samtoolsDir}.tar.bz2"
    ) ->-
    Seq("tar", "--bzip2", "-xf", s"${samtoolsDir}.tar.bz2") ->-
    {
      val wd = cwd
      %cd (wd/samtoolsDir).toString
    } ->-
    Seq("make") ->-
    Seq("cp", "samtools", "/usr/bin/") ->-
    success(s"${bundleName} is installed")
  }



}
