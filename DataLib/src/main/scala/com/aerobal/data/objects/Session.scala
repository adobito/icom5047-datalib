package com.aerobal.data.objects

import java.sql.Timestamp

case class Session(id: Int, userId: Int, name: String, description: String, isPublic: Boolean,
		timestamp: Timestamp, isActive: Boolean) extends JSONifier {
	lazy val experiments: List[Experiment] = null;;
	lazy val users: List[User] = null;
	lazy val groups: List[Group] = null;
}