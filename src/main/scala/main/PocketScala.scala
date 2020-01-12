package main

import conf.PocketConfParser
import io.Reader

object PocketScala extends App {
  val conf = PocketConfParser.parse
  val reader = Reader(conf)

  reader.read
}
