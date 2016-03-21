//  http://vishnu667.github.io/run-time-scala-script-evaluation-using-twitters-util-eval/

import com.twitter.util.Eval
import java.io.File

object EvalExample extends App {

    val eval = new Eval // Initializing The Eval without any target location
    val csvEval: EvalInterface = eval[EvalInterface](new File("/path/csv.scala"))
    val tsvEval: EvalInterface = eval[EvalInterface](new File("/path/tsv.scala"))

    val records = Array(
      "1,2,3,4,5",
      "9,8,7,6,5"
      )

    println(csvEval.name)
    records.foreach( i => println(csvEval.orderString( i )))
    println(tsvEval.name)
    records.foreach( i => println(tsvEval.orderString( i )))

}