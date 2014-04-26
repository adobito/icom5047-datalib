package com.aerobal.data.serializers

import com.google.gson.JsonSerializer
import com.aerobal.data.objects.Measurement
import com.google.gson.JsonArray
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonObject
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.aerobal.data.objects.Experiment
import com.google.gson.JsonDeserializationContext
import java.sql.Timestamp
import com.aerobal.data.objects.Measurement

object MeasurementSerializer extends JsonSerializer[Measurement] with JsonDeserializer[Measurement] 
{
  			val gson = GlobalGson.gson;
def serialize(src: Measurement, typeOfSrc: java.lang.reflect.Type,
			context: JsonSerializationContext): JsonElement = {
			val json = new JsonObject();
			val typeOf = new JsonPrimitive(src.typeOf);
			val value = new JsonPrimitive(src.value);
			val id = new JsonPrimitive(src.id);
			val timestamp = gson.toJsonTree(src.timestamp);
			json.add("typeOf", typeOf);
			json.add("value", value);
			json.add("timestamp", timestamp);
			json.add("id",id);
			json;
	}
	def deserialize(json: JsonElement, typeOfT: java.lang.reflect.Type, context: JsonDeserializationContext): Measurement = {
			val obj =  json.getAsJsonObject();
			val typeOf = obj.getAsJsonPrimitive("typeOf").getAsString();
			val value = obj.getAsJsonPrimitive("value").getAsDouble();
			val id = obj.getAsJsonPrimitive("id").getAsLong();
			val timestamp = gson.fromJson(obj.getAsJsonObject("timestamp"), classOf[Timestamp]);
			val measurement = new Measurement(typeOf, value);
			measurement.id = id;
			measurement.timestamp = timestamp;
			measurement;
	}
}