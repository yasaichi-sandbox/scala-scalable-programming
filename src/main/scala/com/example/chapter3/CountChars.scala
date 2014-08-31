package com.example.chapter3

import scala.io.Source

object CountChars extends App {
  if (args.length > 0) {
    val lines = Source.fromFile(args(0)).getLines().toList
    val maxWidth = lines.map(_.length).max.toString.length

    for(line <- lines)
      println(s"%${maxWidth}d".format(line.length) + " | " + line)

  }
  else
    Console.err.println("Please enter file name.")
}


