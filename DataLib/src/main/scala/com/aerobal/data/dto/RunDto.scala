package com.aerobal.data.dto

import java.sql.Timestamp
import scala.beans.BeanProperty

case class RunDto(@BeanProperty var experimentId: Long) extends JSONifier { 
	@BeanProperty var id: Long = _;
	@BeanProperty var isActive: Boolean = true;
	@BeanProperty var timestamp: Timestamp = new Timestamp(System.currentTimeMillis());
	
	def this() =  {
		this(-1);
	}

}