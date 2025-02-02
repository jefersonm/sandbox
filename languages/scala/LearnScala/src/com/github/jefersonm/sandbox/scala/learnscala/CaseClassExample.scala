package com.github.jefersonm.sandbox.scala.learnscala

class Tree {

	case class Sum(l: Tree, r: Tree) extends Tree
	case class Var(n: String) extends Tree
	case class Const(v: Int) extends Tree

	type Environment = String => Int
	
	def eval(t: Tree, env: Environment): Int = t match {
		case Sum(l, r) => eval(l, env) + eval(r, env)
		case Var(n)    => env(n)
		case Const(v)  => v
	}

	def derive(t: Tree, v: String): Tree = t match {
		case Sum(l, r) => Sum(derive(l, v), derive(r, v))
		case Var(n) if (v == n) => Const(1)
		case _ => Const(0)
	}

	def execute() {
		val exp: Tree = Sum(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")))
		val env: Environment = { case "x" => 5 case "y" => 7 }
		println("Expression: " + exp)
		println("Evaluation with x=5, y=7: " + eval(exp, env))
		println("Derivative relative to x:\n " + derive(exp, "x"))
		println("Derivative relative to y:\n " + derive(exp, "y"))
	}
	
}

object Test {
  
	def main(args: Array[String]) {
		new Tree execute;
	}
	
}