package com.aerobal.data.dto

import com.google.gson.Gson
import com.google.gson.GsonBuilder

case class User(id: Int, username: String, email: String, name: String, isActive: Boolean) extends JSONifier