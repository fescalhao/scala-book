import scala.io.Source

if (args.length > 0) {
  var maxWidth = 0
  val sourceFile = Source.fromFile(args(0))
  val lines: List[String] = sourceFile.getLines().toList

  lines.foreach(line => {
    maxWidth = maxWidth.max(widthOfLength(line))
  })
  // or
  val longestLine = lines.reduceLeft(
    (l1, l2) => if (l1.length > l2.length) l1 else l2
  )

  maxWidth = widthOfLength(longestLine)

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " - " + line)
  }

  sourceFile.close()
} else {
  Console.err.println("Please enter filename")
}

def widthOfLength(s: String) = {
  s.length.toString.length
}