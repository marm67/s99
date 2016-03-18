trait ListSoluciones {

	def last[T](xs: List[T]): T = xs.last

	def penultimate[T](xs: List[T]): T = last( xs.init )

	def nth[T](i: Int, xs: List[T]): T = xs(i)

	def length[T](xs: List[T]): Int = xs.foldLeft(0)( (acc,_) => acc + 1 )

	def reverse[T](xs: List[T]): List[T] = xs.foldLeft(List[T]())( (acc,x) => x :: acc ) 

	def isPalindrome[T](xs: List[T]): Boolean = xs == reverse(xs)

	def flatten[T](xs: List[Any]): List[T] = xs.foldLeft(List[T]()) { (acc,x) =>
		x match {
			case xs: List[Any] 	=> acc ++ flatten(xs)
			case x: T	 		=> acc ++ List[T](x)
		}
	}
	
	def compress[T](xs: List[T]): List[T] = xs.foldLeft(List[T]()) { (acc,x) => 
		if ( length(acc) > 0 && acc.last == x ) acc else acc ++ List(x) 
	}

	def pack[T](xs: List[T]): List[List[T]] = xs.foldLeft(List[List[T]]()) { (acc,x) => 
		acc match {
			case Nil	=> List(x) :: Nil
			case _		=> if ( acc.last.head == x ) acc.init ++ List( x :: acc.last ) else acc ++ ( List(x) :: Nil )
		}
	}

}