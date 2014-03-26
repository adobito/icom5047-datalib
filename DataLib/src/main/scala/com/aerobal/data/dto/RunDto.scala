package com.aerobal.data.dto

import java.sql.Timestamp

case class RunDto(id: Int, experimentId: Int, timestamp: Timestamp) extends JSONifier