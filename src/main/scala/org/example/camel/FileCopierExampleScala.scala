package org.example.camel

import org.apache.camel.CamelContext
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.scala.dsl.builder.ScalaRouteBuilder


object FileCopierExampleScala {
  def main(args: Array[String]) {
    val context: CamelContext = new DefaultCamelContext

    context.addRoutes(new ScalaRouteBuilder(context) {
        "file:data/inbox?noop=true" --> "file:data/outbox"
    })

    context.start()
    Thread.sleep(10000)
    context.stop()
  }
}


