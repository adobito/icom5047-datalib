package com.aerobal.data.serializers

import com.aerobal.data.objects.Experiment
import com.aerobal.data.objects.Run
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.JsonDeserializationContext
import java.sql.Timestamp
import com.google.gson.Gson
import com.google.gson.JsonDeserializer

object ExperimentSerializer extends JsonSerializer[Experiment] with JsonDeserializer[Experiment] {
	val gson = new GsonBuilder().
			registerTypeAdapter(classOf[Run], RunSerializer).
			create();
	def serialize(src: Experiment, typeOfSrc: java.lang.reflect.Type,
			context: JsonSerializationContext): JsonElement = {
			val json = new JsonObject();
			val name = new JsonPrimitive(src.name);
			val amountOfValues = new JsonPrimitive(src.amountOfValues);
			val frequency = new JsonPrimitive(src.frequency);
			val windSpeed = new JsonPrimitive(src.windSpeed);
			val id = new JsonPrimitive(src.id);
			val timestamp = gson.toJsonTree(src.timestamp,classOf[Timestamp]);
			val runsObj = new JsonObject();
			val runs = new JsonArray();
			json.add("name", name)
			json.add("runs",runs);
			json.add("amountOfValues",amountOfValues);
			json.add("frequency", frequency);
			json.add("windSpeed",windSpeed);
			json.add("timestamp", timestamp);
			json.add("id",id);
			src.runs.foreach(run => runs.add(gson.toJsonTree(run)));
			json;
	}

	def deserialize(json: JsonElement, typeOfT: java.lang.reflect.Type, context: JsonDeserializationContext): Experiment = {
			val obj =  json.getAsJsonObject();
			val name = obj.getAsJsonPrimitive("name").getAsString();
			val amountOfValues = obj.getAsJsonPrimitive("amountOfValues").getAsInt();
			val frequency = obj.getAsJsonPrimitive("frequency").getAsInt();
			val windSpeed = obj.getAsJsonPrimitive("windSpeed").getAsDouble();
			val id = obj.getAsJsonPrimitive("id").getAsLong();
			val timestamp = gson.fromJson(obj.getAsJsonPrimitive("timestamp"), classOf[Timestamp]);
			val experiment = new Experiment(name,amountOfValues,frequency,windSpeed);
			val runs = obj.getAsJsonArray("runs");
			val runsIterator = runs.iterator();
			while(runsIterator.hasNext()) {
				experiment.runs.append(gson.fromJson(runsIterator.next(), classOf[Run]));
			}
			experiment.id = id;
			experiment.timestamp = timestamp;
			experiment;
	}
}