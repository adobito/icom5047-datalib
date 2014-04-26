package com.aerobal.data.dto

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import scala.beans.BeanProperty
import com.aerobal.data.serializers.JSONifier

case class UserDto(
		@BeanProperty var hash: String,
		@BeanProperty var email: String, 
		@BeanProperty var name: String)
		extends JSONifier {
	@BeanProperty var id: Long = _;
	@BeanProperty var token: String = "";
	@BeanProperty var isActive: Boolean = true;

	def this() = {
		this("","","");
	}
}