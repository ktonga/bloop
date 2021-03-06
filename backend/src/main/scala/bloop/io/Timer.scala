package bloop.io

import bloop.logging.Logger

object Timer {

  @inline def timed[T](logger: Logger)(op: => T): T = {
    val start = System.nanoTime()
    try op
    finally {
      val elapsed = (System.nanoTime() - start).toDouble / 1e6
      logger.debug(s"Elapsed: $elapsed ms")
    }
  }

}
