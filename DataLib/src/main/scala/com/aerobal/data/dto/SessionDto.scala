package com.aerobal.data.dto

import java.sql.Timestamp

case class SessionDto(id: Int, userId: Int, name: String, description: String, isPublic: Boolean,
		timestamp: Timestamp, isActive: Boolean) extends JSONifier {
}