object Main {

	def last[T](xs: List[T]): T = xs.last

	def penultimate[T](xs: List[T]): T = last( xs.init )

	def nth[T](i: Int, xs: List[T]): T = xs(i-1)

	//--------------------------------------------------------
	//   Test
	//--------------------------------------------------------
	def main(args: Array[String]): Unit = {
		val x1 = List(1, 1, 2, 3, 5, 8)
		val x = penultimate(x1)

		println(x)
	}

}