package com.aerobal.data.processing;

import java.security.InvalidParameterException

import com.aerobal.data.processing.exceptions.EmptyListException
object DataProcessing {

	def max(list: List[Double]): Double = {
			nullListCheck(list);
			if(list.isEmpty) {
				0;
			}
			else {
				list.max;
			}
	}
	def min(list: List[Double]): Double = {
			nullListCheck(list);
			if(list.isEmpty) {
				0;
			}
			else {
				list.min;
			}
	}
	def mean(list: List[Double]): Double = {
			nullListCheck(list);
			if(list.isEmpty) {
				0;
			}
			else {
				list.sum / list.length;
			}
	}
	def median(list: List[Double]): Double = {
			nullListCheck(list);
			if(list.isEmpty) {
				0;
			}
			else {
				val sorted = list.sorted;
				if(list.size % 2 == 1)
					sorted((list.size/2).toInt);
				else
					(sorted((list.size/2).toInt - 1) + sorted((list.size/2).toInt))/2;
			}

	}
	def sum(list: List[Double]): Double = {
			nullListCheck(list);
			emptyListCheck(list);

			list.sum
	}
	def standardDeviation(list: List[Double]): Double = {
			standardDeviation(list,mean(list))
	}
	def sort(list: List[Double]): List[Double] = {
			nullListCheck(list);
			emptyListCheck(list);

			list.sorted
	}
	private def standardDeviation(list: List[Double], mean: Double): Double = {
			nullListCheck(list);
			if(list.isEmpty) {
				0;
			}
			else {
				var sum: Double = 0;
				list.foreach(value => { sum += Math.pow((value - mean),2) });
				sum /= list.size;
				sum = Math.sqrt(sum);
				sum;
			}

	}
	private def emptyListCheck(list: List[Double]) {
		if(list.isEmpty)
			throw new EmptyListException("Received list is empty.");
	}
	private def nullListCheck(list: List[Double]) {
		if(list == null)
			throw new InvalidParameterException("List passed was null.");
	}

}