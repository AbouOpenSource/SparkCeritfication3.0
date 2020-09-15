// Functions

//Format def <function name> (parameter name: type...) : return type = {}

def square (x: Int ) : Int = {
  x*x
}

def cubeIt(x : Int) : Int = {
  x*x*x
}

println(square(2))
println(cubeIt(3))

def tranformInt( x: Int , f: Int => Int ): Int = {
  f(x)
}
val result =tranformInt(10, square)

println(result)


val resultBis =tranformInt(10, x => x+x+x+x)


val resultsBis =tranformInt(10, x => {val y = x*x; y *y})
