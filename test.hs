import Point 
import City
import Quality
import Link

point1 = newP 1 2
point2 = newP 0 0
city1 = newC "Vice City" point1
city2 = newC "Liberty City" point2
qua = newQ "deAaB" 3 0.5
ab = newL city1 city2 qua

test = [difP (newP 1 2) (newP 0 0) == sqrt 5,
        nameC city1 == "Vice City",
        distanceC city1 city2 == sqrt 5,
        capacityQ qua == 3,
        delayQ qua == 0.5,
        connectsL city1 ab,
        linksL city2 city1 ab,
        capacityL ab == 3,
        delayL ab == 0.5,
        True]