package org.example.camel

import org.apache.camel.{Exchange, CamelContext}
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.scala.dsl.builder.ScalaRouteBuilder


/**
  * Reads data from standard input stream and copy it to the stdout.
  * This examples uses camel-stream component (separate dependency).
  */
object ConsoleExample {
  def main(args: Array[String]) {
    val context: CamelContext = new DefaultCamelContext

    context.addRoutes(new ScalaRouteBuilder(context) {
        "stream:in?promptMessage=Enter something" ==> {
          process {(ex) => ex.in = ex.in.toString.toUpperCase}
          --> ("stream:out")
        }
    })

    context.start()
    Thread.sleep(20000)
    context.stop()
  }
}


