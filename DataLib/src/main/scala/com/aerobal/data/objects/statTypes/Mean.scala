package com.aerobal.data.objects.statTypes

import com.aerobal.data.processing.DataProcessing
import com.aerobal.data.objects.Measurement

object Mean extends StatType  {
	def calculate(values: List[Double]):Double = {
	  DataProcessing.mean(values);
	}
}