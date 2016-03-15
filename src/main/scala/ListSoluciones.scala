trait ListSoluciones {

	def last[T](xs: List[T]): T = xs.last

	def penultimate[T](xs: List[T]): T = last( xs.init )

	def nth[T](i: Int, xs: List[T]): T = xs(i)

	def length[T](xs: List[T]): Int = xs.foldLeft(0)((acc,_) => acc+1)

	def reverse[T](xs: List[T]): List[T] = {
		def f(acc: List[T], xs: List[T]): List[T] = {
			xs match {
				case Nil	=> acc
				case ys		=> f( ys.last :: acc, xs.init )
			}
		}

		f(Nil, xs)
	}
	
}