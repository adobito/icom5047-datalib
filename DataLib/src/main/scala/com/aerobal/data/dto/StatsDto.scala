package com.aerobal.data.dto

import scala.collection.immutable.HashMap
import java.util.Collection
import java.security.InvalidParameterException
import com.aerobal.data.serializers.JSONifier

case class StatsDto(stats: HashMap[String,Double], types: Collection[String]) extends JSONifier{
	def apply(typeName: String): Double = {
	  if(types.contains(typeName)) {
	    stats(typeName)
	  }
	  else {
	    throw new InvalidParameterException("Unrecognized Type Used: "  +typeName)
	  }
	}
}