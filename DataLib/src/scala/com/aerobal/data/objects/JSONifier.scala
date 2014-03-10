package com.aerobal.data.objects

import com.google.gson.GsonBuilder

trait JSONifier {

  override def toString: String = {
    val gson = new GsonBuilder().create();
    gson.toJson(this)
  }
}