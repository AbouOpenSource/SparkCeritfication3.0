// Flow control

//If and ellse

if( 3 >1 ) println(" It is true") else println("It is false")
if(1>3){
  println("aluuuu")
  println("heloooo")
}else{
  println("On dit quoi")
  println("Comment tu vas")
}

val number = 3
number match {
  case 1 => println("one")
  case 2 => println("two")
  case 3 => println("three")
  case _ => println("Else")

}

for (x <- 1 to 4){
  val squred = x*x
  println(squred)
}

var x =10
while (x >= 0){
  println(x)
  x -=1
}
x = 0
do {
  println(x)
  x+=1;
}while(x <=10)

{ val x = 10 ; x + 20}

println({ val x = 10 ; x + 20})

def fibonacci(value: Int): Int = {
  value match {
    case 0 => 0
    case 1 => 1
    case 2 => 1
    case _ => fibonacci(value - 1) + fibonacci(value - 2)
  }
}
fibonacci(10)
