package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._


abstract class samtools(val version: String) extends Bundle(cdevel, compressinglibs, ncurses) {

  def install: Results = {
    Seq("wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/samtools/${version}/samtools-${version}.tar.bz2") ->-
    Seq("tar", "--bzip2", "-xf", s"samtools-${version}.tar.bz2" ) ->-
    Seq("cd", "samtools-${version}") ->-
    Seq("make") ->-
    Seq("cp", "samtools", "/usr/bin/") ->-
    success(s"${bundleName} is installed")
  }





}
