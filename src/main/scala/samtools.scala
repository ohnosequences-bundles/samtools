package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._


abstract class Samtools(val samtoolsVersion: String) extends Bundle(cdevel, compressinglibs, ncurses) {

  def install: Results = {
    Seq("wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/samtools/${samtoolsVersion}/samtools-${samtoolsVersion}.tar.bz2") ->-
    Seq("tar", "--bzip2", "-xf", s"samtools-${samtoolsVersion}.tar.bz2" ) ->-
    Seq("cd", s"samtools-${samtoolsVersion}") ->-
    Seq("make") ->-
    Seq("cp", "samtools", "/usr/bin/") ->-
    success(s"${bundleName} is installed")
  }



}


