package com.aerobal.data.dto

import java.sql.Timestamp

case class Run(id: Int, experimentId: Int, timestamp: Timestamp) extends JSONifier {
  lazy val measurements: List[Measurement] = null;
  lazy val stats: Stats = null;
  
}