
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
    pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === 
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  }

  "P10 (*) Run-length encoding of a list" >> {
    encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === 
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  }

  "P11 (*) Modified run-length encoding" >> {
    encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  }

  "P12 (**) Decode a run-length encoded list" >> {
    decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) ===
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  }

  "P13 (**) Run-length encoding of a list (direct solution)" >> {
    encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  }

  "P14 (*) Duplicate the elements of a list" >> {
    duplicate(List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  }

  "P15 (**) Duplicate the elements of a list a given number of times" >> {
    duplicateN(3, List('a, 'b, 'c, 'c, 'd)) ===
      List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  }

  "P16 (**) Drop every Nth element from a list" >> {
    drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  }

  "P17 (*) Split a list into two parts" >> {
    split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }

  "P18 (**) Extract a slice from a list" >> {
    slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      List('d, 'e, 'f, 'g)
  }

  "P19 (**) Rotate a list N places to the left" >> {
    rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === 
               List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  }

  "P20 (*) Remove the Kth element from a list" >> {
    removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd),'b)
  }

}