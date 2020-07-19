package com.calcifer.cassie

import java.util.UUID


case class User(
  id: UUID,
  userName: String,
  email: String
)
