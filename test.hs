import Point 
import City
import Quality
import Link

data Point = Poi Int Int deriving (Eq, Show)



point1 = newP 1 2
point2 = newP 0 0
city1 = newC "Vice City" point1
city2 = newC "Liberty City" point2
qua = newQ "deAaB" 3 0.5
ab = newL city1 city2 qua

test = [ newP 1 2 == 1 2,
         difP point1 point2 == sqrt 5,
         city1 == Cit "Vice City" (newP 1 2),
         nameC city1 == "Vice City",
         distanceC city1 city2 == sqrt 5,
         qua == Qua "deAaB" 3 0.5,
         capacityQ qua == 3,
         delayQ qua == 0.5,
         ab == Lin (newC "A" (Poi 1 2)) (newC "B" (Poi 0 0)) (newQ "deAaB" 3 0.5),

         True]