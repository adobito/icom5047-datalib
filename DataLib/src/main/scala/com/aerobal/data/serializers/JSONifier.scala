package com.aerobal.data.serializers
import com.google.gson.Gson

trait JSONifier {
  override def toString: String = {
    GlobalGson.gson.toJson(this);
  }
}