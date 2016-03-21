object Main extends App with ListSoluciones {
	val k1 = removeAt(1, List('a, 'b, 'c, 'd)) // === (List('a, 'c, 'd),'b)
	println(k1)

}
