// Value are immutable constants
val test: String = "Hello !!"
// VARIABLES are mutable
var helloTHer : String = test + " Concat"
println(helloTHer);

val immutableHelloThere = test + " There"

println(immutableHelloThere)



// Data types

val numberOne: Int = 1
val truth: Boolean = true
val letterA: Char = 'a'
val pi:Double = 3.14153265
val singlePrecision: Float = 3.14153265f
val bigNumber : Long = 123456789
val smallNumber : Byte = 127

println("Here is a mess: "+ numberOne + truth +letterA + bigNumber )

println(f"Pi is about $singlePrecision%3f")

println(f"Zero padding on the left : $numberOne%05d")

println(s"I can use the s prefix to use variabes like $numberOne : $smallNumber%05d")

val ultimateAnswer: String = " THe life, the universe and everything 458 salut "

val pattern = """.*([\d]+).*""".r

val pattern(answerString) = ultimateAnswer

val answer = answerString.toInt

val isGreater = 1 > 2
val isLesser = 1 < 2

val impossible  = isGreater & isLesser
val anotherWay = isGreater || isLesser

val picard: String = "Picard"
val bestCaptain: String = "Picard"

val isBest: Boolean = picard == bestCaptain

def excercice (value:Long) = {
    println(f"La valeur double est : ${value *2}")
}

excercice(20)