package org.smartjava

import spray.json.DefaultJsonProtocol

/**
  * Created by amozh on 5/31/16.
  */
object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val personFormat = jsonFormat3(Person)
}

case class Person(name: String, fistName: String, age: Long)