package com.aerobal.data.objects.statTypes

import com.aerobal.data.processing.DataProcessing

case object Max extends StatType  {
	def calculate(values: List[Double]):Double = {
	  DataProcessing.max(values);
	}
}