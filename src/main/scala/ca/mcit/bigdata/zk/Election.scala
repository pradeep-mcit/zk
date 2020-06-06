package ca.mcit.bigdata.zk

import org.apache.curator
import org.apache.curator.framework.{CuratorFramework, CuratorFrameworkFactory}
import org.apache.curator.framework.recipes.leader.{LeaderSelector, LeaderSelectorListener}
import org.apache.curator.framework.state.ConnectionState
import org.apache.curator.retry.ExponentialBackoffRetry


object Election extends App {

  val r = new ExponentialBackoffRetry(1000,10)
  val client = CuratorFrameworkFactory.newClient("172.16.129.58:2181",r)

  client.start()
  client.blockUntilConnected()
  val selector = new LeaderSelector(client,"/user/summer2019/pradeep",new LeaderSelectorListener {
    override def takeLeadership(client: CuratorFramework): Unit =
      println("I'm the leader")

    override def stateChanged(client: CuratorFramework, newState: ConnectionState): Unit =
      print(newState)
  })
  selector.setId("leader1")
  selector.start()
  while(true) Thread.sleep(1000)

}
