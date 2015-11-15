package org.example.camel

import org.apache.camel.CamelContext
import org.apache.camel.impl.{SimpleRegistry, DefaultCamelContext}
import org.apache.camel.scala.dsl.builder.ScalaRouteBuilder
import org.slf4j.{LoggerFactory, Logger}


/**
  * Reads data from standard input stream and copy it to the stdout.
  * This examples uses camel-stream component (separate dependency).
  */
object PipesAndFiltersExample {

  val logger = LoggerFactory.getLogger("pipes-and-filters")

  trait OrderProcessingBean {
    def processContent(orderContent: String): String
  }
  class Decrypt extends OrderProcessingBean {
    override def processContent(orderContent: String): String = {
      logger.info(orderContent)
      orderContent
    }
  }
  class Authenticate extends OrderProcessingBean {
    override def processContent(orderContent: String): String = {
      logger.info(orderContent)
      orderContent
    }
  }
  class Dedup extends OrderProcessingBean {
    override def processContent(orderContent: String): String = {
      logger.info(orderContent)
      orderContent
    }
  }

  def main(args: Array[String]) {
    val registry: SimpleRegistry = new SimpleRegistry
    registry.put("decrypt", new Decrypt)
    registry.put("authenticate", new Authenticate)
    registry.put("dedup", new Dedup)
    val context: CamelContext = new DefaultCamelContext(registry)


    context.addRoutes(new ScalaRouteBuilder(context) {
      // note that both explicit method name and "autodetection" should work
      // noop=true is used to ensure that camel doesn't remove source file and thus this example can work multiple
      // time without the need to manualy copy the file to the /data/orders-inbox directory
        "file:data/orders-inbox?noop=true" ==> {
          --> ("bean:decrypt?method=processContent")
          --> ("bean:authenticate")
          --> ("bean:dedup")
        }
    })

    context.start()
    Thread.sleep(10000)
    context.stop()
  }
}


