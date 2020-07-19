package com.calcifer.cassie

import scala.concurrent._

import com.outworkers.phantom.dsl._

trait UserDatabaseService extends UserDatabaseProvider {

  def createUser(
      uuid: UUID,
      userName: String,
      email: String
  ): Future[ResultSet] =
    database.users
      .createUserById(uuid, userName, email)

  def selectUserById(uuid: UUID): Future[Option[User]] =
    database.users.getById(uuid)

  def selectUserByFirstName(userName: String): Future[Option[User]] =
    database.users.getByName(userName)

}

object databaseService extends UserDatabaseService {
  override def database: UserDatabase = Database
}
