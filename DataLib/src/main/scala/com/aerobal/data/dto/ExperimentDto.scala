package com.aerobal.data.dto

import java.sql.Timestamp

case class ExperimentDto(id: Int, sessionId: Int, name: String, amountOfValues: Int, frquency: Int,
		windSpeed: Double, timestamp: Timestamp) extends JSONifier