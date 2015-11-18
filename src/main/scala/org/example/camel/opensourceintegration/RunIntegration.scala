package org.example.camel.opensourceintegration

import org.springframework.context.support.ClassPathXmlApplicationContext

/**
  * Application wrapper for starting the order system integration.
  */
object RunIntegration {

  def main(args: Array[String]) {
    val applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml")

  }
}
