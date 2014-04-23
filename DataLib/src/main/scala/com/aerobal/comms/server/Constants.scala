package com.aerobal.comms.server

object Constants {
	val USER_USERNAME_STRING = "username";
	val USER_NAME_STRING = "name";
	val USER_EMAIL_STRING = "email";
	val USER_PASSWORD_STRING = "password";
	val USER_ID_STRING = "userId";
	val SESSION_ID_STRING = "sessionId";
	val SESSION_NAME_STRING = "name";
	val SESSION_DESCRIPTION_STRING = "desc";
	val EXPERIMENT_ID_STRING = "experimentId";
	val EXPERIMENT_NAME_STRING = "name";
	val EXPERIMENT_DESCRIPTION_STRING = "description";
	val EXPERIMENT_MEASUREMENT_AMOUNT_STRING = "measurementAmount";
	val EXPERIMENT_FREQUENCY_STRING = "frequency";
	val ID_STRING = "id";
	val RUN_ID_STRING = "runId";
	val MEASUREMENT_ID_STRING = "measurementId";
	val MEASUREMENT_TYPE_STRING = "type";
	val MEASUREMENT_VALUE_STRING = "value";
	val TIMESTAMP_STRING = "timestamp";
	
	val HOST_ADDRESS = "http://127.0.0.1:9000/"
	
	val GET_SESSION_ROUTE = "session";
	val GET_EXPERIMENT_ROUTE = "experiment";
	val GET_RUN_ROUTE = "run";
	val GET_USER_ROUTE = "user";
	val GET_EXPERIMENT_STATS_ROUTE = "experimentstats";
	val GET_RUN_STATS_ROUTE  = "runstats";
	val GET_MEASUREMENT_ROUTE = "measurement";
	val GET_MULTIPLE_EXPERIMENTS_ROUTE = "experiments";
	val GET_MULTIPLE_SESSIONS_ROUTE = "sessions";
	val GET_MULTIPLE_RUNS_ROUTE = "runs";
	val GET_MULTIPLE_MEASUREMENTS_ROUTE = "measurements";
	
	val POST_NEW_USER_ROUTE = "new_user";
	val POST_NEW_SESSION_ROUTE = "new_session";
	val POST_NEW_EXPERIMENT_ROUTE = "new_experiment";
	val POST_NEW_RUN_ROUTE = "new_run";
	val POST_NEW_MEASUREMENT_ROUTE = "new_measurement";
	val POST_AUTH_ROUTE = "auth"
	
	val PUT_UPDATE_SESSION_ROUTE = "update_session";
	val PUT_UPDATE_EXPERIMENT_ROUTE = "update_experiment";
	
	val DELETE_SESSION_ROUTE = "delete_session";
	val DELETE_EXPERIMENT_ROUTE = "delete_experiment";
	val DELETE_RUN_ROUTE = "delete_session";
	val DELETE_CONFIRM_JSON_KEY = "confirm";
	
	
	

}