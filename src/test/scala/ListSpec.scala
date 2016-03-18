
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

  "P06 Find out whether a list is a palindrome" >> {
    isPalindrome(List(1, 2, 3, 2, 1)) === true
  }

  "P07 Flatten a nested list structure" >> {
    flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8)
  }

  "P08 Eliminate consecutive duplicates of list elements" >> {
    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List('a, 'b, 'c, 'a, 'd, 'e)
  }

  "P09 (**) Pack consecutive duplicates of list elements into sublists" >> {
    pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  }

}