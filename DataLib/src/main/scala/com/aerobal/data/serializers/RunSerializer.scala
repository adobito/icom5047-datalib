package com.aerobal.data.serializers

import java.sql.Timestamp
import com.aerobal.data.objects.Measurement
import com.aerobal.data.objects.Run
import com.google.gson.JsonArray
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object RunSerializer extends JsonSerializer[Run] with JsonDeserializer[Run]  {
	val gson  = new GsonBuilder().
  registerTypeAdapter(classOf[Measurement], MeasurementSerializer).
  create();
	def serialize(src: Run, typeOfSrc: java.lang.reflect.Type,
			context: JsonSerializationContext): JsonElement = {
			val json = new JsonObject();
			val id = new JsonPrimitive(src.id);
			val timestamp = gson.toJsonTree(src.timestamp);
			val measurements = new JsonArray();
			json.add("timestamp", timestamp);
			json.add("id",id);
			json.add("measurements",measurements);
			src.measurements.foreach(measurement => measurements.add(gson.toJsonTree(measurement)));
			json;
	}
	def deserialize(json: JsonElement, typeOfT: java.lang.reflect.Type, context: JsonDeserializationContext): Run = {
			val obj =  json.getAsJsonObject();
			val id = obj.getAsJsonPrimitive("id").getAsLong();
			val timestamp = gson.fromJson(obj.getAsJsonPrimitive("timestamp"), classOf[Timestamp]);
			val run = new Run();
			val measurements = obj.getAsJsonArray("measurements");
			val measurementIterator = measurements.iterator();
			while(measurementIterator.hasNext()) {
			  run.measurements.append(gson.fromJson(measurementIterator.next(), classOf[Measurement]));
			}
			run.id = id;
			run.timestamp = timestamp;
			run;
	}
}