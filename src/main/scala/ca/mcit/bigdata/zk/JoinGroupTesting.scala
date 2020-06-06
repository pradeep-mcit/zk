package ca.mcit.bigdata.zk

object JoinGroupTesting extends  App {

  val server = "172.16.129.58:2181"

  val lp1= new  DataNode("zoo","lp1")
  lp1.connect(server)
  lp1.operation()

  val lp2= new  DataNode("zoo","lp2")
  lp2.connect(server)
  lp2.operation()

  val lp3= new  DataNode("zoo","lp3")
  lp3.connect(server)
  lp3.operation()

  Thread.sleep(Long.MaxValue)

}
