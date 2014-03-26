package com.aerobal.data.objects

import java.sql.Timestamp

case class Session(user:User, name: String, description: String, isPublic: Boolean) {
}