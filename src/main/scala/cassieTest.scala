import scala.concurrent._

import java.util.UUID

import org.slf4j.{Logger, LoggerFactory}
import com.outworkers.phantom.dsl._

import com.calcifer.cassie.Connector.connector
import com.calcifer.cassie.{UserDatabase, UserDatabaseService, databaseService}
import com.calcifer.cassie.User

object CassandraMain extends App {

  val logger: Logger = LoggerFactory.getLogger(classOf[App])
  implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

  implicit val cassandraConnection: CassandraConnection =
    ContactPoint.local
      .keySpace("phantom")

  val user = User(UUID.randomUUID(), "marco", "marco@email.com")
  println(user)

  databaseService.createUser(UUID.randomUUID(), "marco", "marco@email.com")
}
