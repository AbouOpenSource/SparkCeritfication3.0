// Data structures

//Tuples
//Immutable lists

val captainStuff = ("PIcard","Entrprise-D","NCC-YACOUBA")
println(captainStuff);

//Refer to the individual fields with  a ONE-BASED index

println(captainStuff._1)
println(captainStuff._2)
println(captainStuff._3)

val picardSHip = "Picard" -> "Entrepirse"

println(picardSHip._2)

val aBucnchOfStuff = ("Kirikou", 1964, true)


// Lists
//Like a tuple but more functionnality

// Must be of same type

val shipList = List("SANOU", "Kane", " Abou", " Dramane ")
println(shipList(1))

println(shipList.head)

println(shipList.tail)


for (ship <- shipList){
  println(ship);
}

val backwardShips = shipList.map((ship: String) => {ship.reverse} )


for (bship <- backwardShips){
  println(bship);
}

// reduc() to combine together all the items in a colletion using

val numberlIts = List(1,2,3,4,5,6,7,9)
val sum = numberlIts.reduce( (x: Int, y: Int)=> x + y )
println(sum)

// filter() removes stuff

val iHateFives = numberlIts.filter((x : Int)=> x!=5)

val iHatethree = numberlIts.filter(_ !=5)

//Concate lists

val moreNumbers = List(6,7,28)
val lotsOfNumbers = numberlIts ++ moreNumbers

val reversed = numberlIts.reverse
val sorted = numberlIts.sorted

val duplicated = numberlIts ++ numberlIts

val distinct = duplicated.distinct

val total = numberlIts.sum

val hasThree = iHatethree.contains(3)



//Maps

val shipMap = Map ("SANOU" -> "Mah KAne", "Kane"-> " Bosso", "Tanou" -> " Chasser")

println(shipMap("SANOU"))
println(shipMap.contains("Archer"))

val archerShip = util.Try(shipMap("Archer")) getOrElse "Unknow"
