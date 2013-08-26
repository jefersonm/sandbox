package com.github.jefersonm.sandbox.scala.learnscala

import java.util.{Date, Locale}
import java.text.DateFormat._

object InteroperateExample {

	def main(args: Array[String]){
		val now = new Date
		val df = getDateInstance(LONG, Locale.GERMAN)
		println(df format now)
		println(df.format(now))
	}

}