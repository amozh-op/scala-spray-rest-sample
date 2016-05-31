package org.smartjava;

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

/**
  * Created by amozh on 5/31/16.
  */
object Boot extends App {

  // create our actor system with the name amozh
  implicit val system = ActorSystem("amozh")
  val service = system.actorOf(Props[SJServiceActor], "amozh-rest-service")

  // IO requires an implicit ActorSystem, and ? requires an implicit timeout
  // Bind HTTP to the specified service.
  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
