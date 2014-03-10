package com.aerobal.data.objects

import java.sql.Timestamp

class Run(id: Int, experimentId: Int, timestamp: Timestamp) extends JSONifier {
  lazy val measurements: List[Measurement] = null;
  lazy val stats: Stats = null;
  
}