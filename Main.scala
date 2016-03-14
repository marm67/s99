class Main {

	def last[T](xs: List[T]): T = {
		xs match {
			case x :: Nil	=> x
			case x :: xs	=> last(xs)
		}
	}

	//--------------------------------------------------------
	//   Test
	//--------------------------------------------------------
	def main(args: Array[String]): Unit = {
		val x1 = List(1, 1, 2, 3, 5, 8)
		val x = last(x1)

		println(x)
	}

}