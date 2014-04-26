package com.aerobal.data.dto

import scala.beans.BeanProperty
import java.sql.Timestamp
import com.aerobal.data.serializers.JSONifier

case class RunStatDto(@BeanProperty var runId: Long,
		@BeanProperty var statTypeId: Int,
		@BeanProperty var value: Double) extends JSONifier {
	@BeanProperty var id: Long = _;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
	def this() {
	  this(-1, -1, -1);
	}
}