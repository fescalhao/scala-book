package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.recipe

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.classes.impl.Recipe
import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.ingredient.{Apple, Cream, Orange, Sugar}

object FruitSalad extends Recipe("Fruit Salad", List(Apple, Orange, Cream, Sugar), "Mix it all!")
