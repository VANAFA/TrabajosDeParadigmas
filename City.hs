module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name point = Cit name point

nameC :: City -> String
nameC (Cit name point) = name

distanceC :: City -> City -> Float
distanceC x s = 34

test = [ newC "Andalgalá" (newP 1 2) == Cit "Andalgalá" (newP 1 2),
         nameC (newC "Vice City" (newP 1 2)) == "Vice City",
         True]