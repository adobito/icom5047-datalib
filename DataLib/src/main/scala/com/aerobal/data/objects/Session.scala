package com.aerobal.data.objects

import java.sql.Timestamp
import com.aerobal.data.serializers.JSONifier
import scala.beans.BeanProperty
import com.aerobal.data.dto.SessionDto

case class Session(@BeanProperty var name: String,
		@BeanProperty var description: String,
		@BeanProperty var isPublic: Boolean) extends JSONifier {
	@BeanProperty var id: Long = _;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
	
	def this(sessionDto: SessionDto) {
	  this(sessionDto.name, sessionDto.description, sessionDto.isPublic);
	  this.id = sessionDto.id;
	  this.timestamp = sessionDto.timestamp;
	}
}
