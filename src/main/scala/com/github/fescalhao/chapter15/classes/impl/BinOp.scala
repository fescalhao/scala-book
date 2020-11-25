// Case Classes and Pattern Matching

package com.github.fescalhao.chapter15.classes.impl

import com.github.fescalhao.chapter15.classes.abs.Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
