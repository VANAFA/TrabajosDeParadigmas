module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name point = Cit name point

nameC :: City -> String
nameC (Cit name _) = name

distanceC :: City -> City -> Float
distanceC (Cit _ p1) (Cit _ p2) = difP p1 p2

city1 = newC "Vice City" (newP 1 2)
city2 = newC "Liberty City" (newP 0 0)

test = [ city1 == Cit "Vice City" (newP 1 2),
         nameC city1 == "Vice City",
         distanceC city1 city2 == sqrt 5,
         True]