package ohnosequencesBundles.statika

import ohnosequences.statika._
import java.io.File


abstract class Samtools(val version: String)
  extends Bundle(cdevel, compressinglibs, ncurses) { samtools =>

  val name = "samtools-" + version
  val tarBz = name + ".tar.bz2"

  lazy val download: CmdInstructions = cmd("wget")(
    s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/samtools/${version}/${samtools.tarBz}"
  )

  lazy val untar: CmdInstructions = cmd("tar")("--bzip2", "-xf", samtools.tarBz)

  lazy val make: CmdInstructions = cmd("make")("-C", samtools.name)

  lazy val link: CmdInstructions = cmd("ln")("-s",
    new File(s"${samtools.name}/samtools").getCanonicalPath,
    "/usr/bin/samtools"
  )

  def instructions: AnyInstructions = download -&- untar -&- make -&- link

}
