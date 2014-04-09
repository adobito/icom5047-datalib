package com.aerobal.data.dto

import java.sql.Timestamp
import scala.beans.BeanProperty

case class SessionDto(@BeanProperty var userId: Long,
		@BeanProperty var name: String,
		@BeanProperty var description: String,
		@BeanProperty var isPublic: Boolean) extends JSONifier {
	@BeanProperty var id: Long = _;
	@BeanProperty var isActive: Boolean = true;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
	def this() = {
		this(-1, "", "", false);
	}
}