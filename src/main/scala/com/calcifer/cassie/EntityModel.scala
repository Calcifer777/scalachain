package com.calcifer.cassie

import scala.concurrent._
import com.outworkers.phantom.dsl._

abstract class Users extends Table[Users, User] {
  object id extends UUIDColumn with PartitionKey
  object userName extends StringColumn
  object email extends StringColumn

  def getById(uuid: UUID): Future[Option[User]] =
    select
      .all()
      .where(_.id eqs uuid)
      .one()

  def getByName(userName: String): Future[Option[User]] =
    select.where(_.userName eqs userName).one()

  def getByEmail(email: String): Future[Option[User]] =
    select.where(_.email eqs email).one()

  def createUserById(
      uuid: UUID,
      userName: String,
      email: String
  ): Future[ResultSet] =
    insert
      .value(_.id, uuid)
      .value(_.userName, userName)
      .value(_.email, email)
      .future()

}
