package org.example.camel.opensourceintegration

import javax.xml.bind.annotation.{XmlAttribute, XmlAccessType, XmlRootElement, XmlAccessorType}
import org.apache.camel.dataformat.bindy.annotation.{DataField, CsvRecord}


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@CsvRecord(separator = ",", skipFirstLine = true)
class Order (@XmlAttribute @DataField(pos=1) var name: String,
             @XmlAttribute @DataField(pos=2) var amount: Int) extends Serializable {

  def this() {
    this("", 0)
  }
}