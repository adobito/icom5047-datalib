package com.aerobal.data.dto

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import scala.beans.BeanProperty

case class UserDto(
		@BeanProperty var username: String, 
		@BeanProperty var password: String,
		@BeanProperty var email: String, 
		@BeanProperty var name: String)
		extends JSONifier {
	@BeanProperty var id: Long = _;
	@BeanProperty var salt: String = "";
	@BeanProperty var token: String = "";
	@BeanProperty var isActive: Boolean = true;

	def this() = {
		this("","","","");
	}
}