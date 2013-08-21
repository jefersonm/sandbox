package com.github.jefersonm.sandbox.scala.learnscala

object BasicExamples {
  
	def main(args: Array[String]){
		println("Hello World!")
		
		val x = 2
		
		println(1 + 2 * 3 / x)
		println( (1).+(((2).*(3))./(x)) ) //Numbers are objects
		
		println(1.+(2)) //Interpreted as a double
		println((1).+(2))
	}

}