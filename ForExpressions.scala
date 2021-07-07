import java.io.File
import scala.io.Source

def fileLines(file: File) = Source.fromFile(file).getLines.toList

val filesHere: Array[File] = (new File(".")).listFiles()

def grep(pattern: String): Array[String] =
  for{file <- filesHere
      if file.isFile
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if line.trim.matches(pattern)
    } yield trimmed


grep(".*for.*")
