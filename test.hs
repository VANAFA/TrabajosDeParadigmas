import Tunel

point1 = newP 1 2
point2 = newP 0 0
point3 = newP 3 4
point4 = newP 5 4
city1 = newC "Vice City" point1
city2 = newC "Liberty City" point2
city3 = newC "Los Santos" point3
city4 = newC "San Andres" point4
qua = newQ "qua1" 3 0.5
ViceToLiberty = newL city1 city2 qua
LibertyToSantos = newL city2 city3 qua

test = [difP (newP 1 2) (newP 0 0) == sqrt 5,
        nameC city1 == "Vice City",
        distanceC city1 city2 == sqrt 5,
        capacityQ qua == 3,
        delayQ qua == 0.5,
        connectsL city1 ViceToLiberty,
        linksL city3 city2 LibertyToSantos,
        capacityL ViceToLiberty == 3,
        delayL ViceToLiberty == 0.5,

        True]