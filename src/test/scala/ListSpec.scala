
import org.specs2.mutable._

class ListSpec extends Specification with ListSoluciones {

  val lista = List(1, 1, 2, 3, 5, 8)

  "P01 Find the last element of a list" >> {
    last(lista) === 8
  }

  "P02 Find the last but one element of a list" >> {
  	penultimate(lista) === 5
  }

  "P03 Find the Kth element of a list. Indexado por 0" >> {
  	nth(3,lista) === 3
  }

  "P04 Find the number of elements of a list" >> {
  	length(lista) === 6
  }

  "P05 Reverse a list" >> {
    reverse(lista) === List(8, 5, 3, 2, 1, 1)
  }

  

}