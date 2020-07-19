package com.calcifer.cassie

import org.slf4j.{Logger, LoggerFactory}
import com.outworkers.phantom.dsl._

class UserDatabase(override val connector: CassandraConnection)
    extends Database[UserDatabase](connector) {
  object users extends Users with connector.Connector
}

object Database extends UserDatabase(Connector.connector) {
  val logger: Logger = LoggerFactory.getLogger(classOf[App])
  logger.info("Creating database instance...")
}


// This trait will act as a database instance provider
trait UserDatabaseProvider extends DatabaseProvider[UserDatabase] 

