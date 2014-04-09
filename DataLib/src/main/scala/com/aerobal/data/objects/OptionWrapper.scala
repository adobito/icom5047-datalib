package com.aerobal.data.objects

object OptionWrapper {

  def some[T](some:T): Option[T] = {
    new Some(some);
  }
  def none[T](none:T): Option[T] = {
    None;
  }
}