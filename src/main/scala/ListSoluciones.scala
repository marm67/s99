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
			case x: T	 		=> acc ++ ( x :: Nil )
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

	def encode[T](xs: List[T]): List[(Int, T)] = pack(xs).map { ys => (length(ys), ys.head) }

	def encodeModified[T](xs: List[T]): List[Any] = 
		pack(xs).map { ys => if ( ys.length == 1 ) ys.head else (length(ys), ys.head) }

	def decode[T](xs: List[(Int, T)]): List[T] = {
		def f[T](n: Int, x: T): List[T] = if (n == 0) List() else x :: f(n-1, x)
		xs flatMap { p => f(p._1, p._2) }
	}

	def encodeDirect[T](xs: List[T]): List[(Int,T)] = {
		def pack[T](acc: List[List[T]], xs: List[T]): List[List[T]] =  xs match {
			case Nil => acc
			case _	 => pack( acc ++ (xs.takeWhile( _ == xs.head ).toList :: Nil) , xs.dropWhile( _ == xs.head ).toList )
		}
		pack(List[List[T]](), xs) map { xs => (xs.length, xs.head) } 
	}

	def duplicate[T](xs: List[T]): List[T] = xs flatMap { x => x :: x :: Nil }

	def duplicateN[T](n: Int, xs: List[T]): List[T] = {
		def filler[T](n: Int, v: T): List[T] = n match {
			case 0	=> Nil
			case _	=> v :: filler(n-1, v) 
		}
		xs flatMap { x => filler(n,x) }
	}

	def drop[T](n: Int, xs: List[T]): List[T] = xs match {
		case Nil	=> Nil
		case _ 		=> xs.take(n-1) ++ drop( n, xs.drop(n) )
	}

	def split[T](n: Int, xs: List[T]): (List[T], List[T]) =  xs splitAt n  // ( xs.take(n), xs.drop(n) )

	def slice[T](i: Int, k: Int, xs: List[T]): List[T] =  xs.drop(i).take(k-i)

	def rotate[T](n: Int, xs: List[T]): List[T] =  n match {
		case 0				=> xs
		case i if i > 0 	=> xs.drop(i) ++ xs.take(i)
		case i if i < 0 	=> xs.takeRight(-i) ++ xs.take(xs.length + i)
	}

	def removeAt[T](i: Int, xs: List[T]): (List[T], T) =  ( xs.take(i) ++ xs.drop(i+1) , xs(i) )

}