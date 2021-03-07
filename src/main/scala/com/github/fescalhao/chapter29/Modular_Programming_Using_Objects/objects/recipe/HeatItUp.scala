package com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.recipe

import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.classes.impl.Recipe
import com.github.fescalhao.chapter29.Modular_Programming_Using_Objects.objects.ingredient.FrozenFood

object HeatItUp extends Recipe("Heat it up!", List(FrozenFood), "Put the 'food' in the microwave for 10 minutes")
