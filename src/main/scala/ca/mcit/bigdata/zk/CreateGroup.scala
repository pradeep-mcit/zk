package ca.mcit.bigdata.zk

import org.apache.zookeeper.{CreateMode, ZooDefs}

class CreateGroup(val groupName:String) extends ZKClient {

  def operation(): Unit = {
    val path = s"/summer2019/pradeep/$groupName"

    zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT)

  }

}
