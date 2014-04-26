package com.aerobal.data.objects

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.aerobal.data.serializers.JSONifier
import scala.beans.BeanProperty
import com.aerobal.data.dto.UserDto
import scala.collection.mutable.ListBuffer

case class User(@BeanProperty var name: String,
    @BeanProperty var email: String) extends Serializable {
	@BeanProperty var id: Long = _;
	val sessions = new ListBuffer[Session]();
	
	def this(userDto: UserDto) {
	  this(userDto.name, userDto.email);
	  this.id = userDto.id;
	}
}
	