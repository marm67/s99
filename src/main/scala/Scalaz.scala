// http://eed3si9n.com/learning-scalaz/FoldLeft.html

object Scalaz {

    trait Monoid[A] {
        def mappend(a:A, b:A): A
        def mzero: A
    }

    object Monoid {
        implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
            def mappend(a: Int, b: Int): Int = a + b
            def mzero: Int = 0
        }
        implicit val StringMonoid: Monoid[String] = new Monoid[String] {
            def mappend(a: String, b: String): String = a + b
            def mzero: String = ""
        }
        // implicit val o: Monoid[Option[_]] = new Monoid[Option[_]] {
        //     def mappend(a: Option[_], b: Option[_]): Option[_] = (a,b) match {
        //         case ( _ , None )   => None
        //         case ( None , _ )   => None
        //         case ( Some(x), Some(y) ) => x + y
        //     }

        //     def mzero: Option[_] = Monoid.mzero
        // }
    }

    trait FoldLeft[F[_]] {
        def foldLeft[A,B](xs: F[A], b: B, f: (B,A) => B): B
    }

    object FoldLeft {
        implicit val FoldLeftList: FoldLeft[List] = new FoldLeft[List] {
            def foldLeft[A,B](xs: List[A], b: B, f: (B,A) => B) = xs.foldLeft(b)(f)
        }
    }

    // def sum[A](xs: List[A])(implicit m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)
    // def sum[A: Monoid](xs: List[A]): A = {
    //     val m = implicitly[Monoid[A]]
    //     FoldLeftList.foldLeft(xs, m.mzero, m.mappend)
    // }

    def sum[F[_]: FoldLeft, M: Monoid](xs: F[M]): M = {
        val m  = implicitly[Monoid[M]]
        val fl = implicitly[FoldLeft[F]]
        fl.foldLeft(xs, m.mzero, m.mappend)
    }
    // def sum1(xs: List[Int]): Int = xs.foldLeft(0)(_+_)
    // def sum1(xs: List[String]): String = xs.foldLeft("")(_+_)

    //val xs = List(1,3,3)
    val xs = List("a", "b", "c")
    val suma = sum(xs)

    println(s"""suma = $suma""")

}