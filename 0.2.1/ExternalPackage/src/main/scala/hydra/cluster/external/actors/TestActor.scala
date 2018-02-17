package hydra.cluster.external.actors

import akka.actor.{Actor, ActorLogging}

/**
  * For hydra.cluster.external.actors in ExternalPackage
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/16
  */
class TestActor extends Actor with ActorLogging{

  override def receive: Receive = {
    case msg=> log.info("Receive msg: " +msg.toString )
  }
}
