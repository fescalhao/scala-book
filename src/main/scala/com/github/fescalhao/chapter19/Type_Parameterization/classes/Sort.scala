package com.github.fescalhao.chapter19.Type_Parameterization.classes

class Sort() {

  // Only works for lists that the elements are subtypes of that Ordered trait.
  def orderedMergeSort[T <: Ordered[T]](list: List[T]): List[T] = {

    def merge(list1: List[T], list2: List[T]): List[T] = {
      (list1, list2) match {
        case (Nil, _) => list2
        case (_, Nil) => list1
        case (elem1 :: xlist, elem2 :: ylist) =>
          if (elem1 < elem2) elem1 :: merge(xlist, list2)
          else elem2 :: merge(list1, ylist)
      }
    }

    val n = list.length / 2
    if (n == 0) list
    else {
      val (l1, l2) = list splitAt n
      merge(orderedMergeSort(l1), orderedMergeSort(l2))
    }
  }
}
