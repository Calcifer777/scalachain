package com.calcifer.cassie

import scala.collection.JavaConverters._

import org.slf4j.{Logger, LoggerFactory}
import com.outworkers.phantom.dsl._
import com.typesafe.config.ConfigFactory

object Connector {

  val logger: Logger = LoggerFactory.getLogger(classOf[App])

  logger.info("Creating database connection...")

  private val config = ConfigFactory.load("cassandra.conf")
  private val hosts = config.getStringList("cassandra.host").asScala
  private val keyspace = config.getString("cassandra.keyspace")
  lazy val connector: CassandraConnection =
    ContactPoint.local
      .keySpace(keyspace)
}
