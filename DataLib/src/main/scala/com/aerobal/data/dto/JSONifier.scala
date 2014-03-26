package com.aerobal.data.dto

import com.google.gson.GsonBuilder
import com.google.gson.Gson

trait JSONifier {

	
  override def toString: String = {
    new Gson().toJson(this);
  }
}