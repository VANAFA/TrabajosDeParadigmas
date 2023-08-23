module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import Quality
import City

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city1 city2 quality = Lin city1 city2 quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin c1 c2 _) | (city == c1) || (city == c2) = True
                             | otherwise = False
{-
linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
capacityL :: Link -> Int
delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
-}

-- (Cit name point) (Qua name tunnels delay)
ab = newL (newC "A" (newP 1 2)) (newC "B" (newP 0 0)) (newQ "deAaB" 3 0.5)

test = [ ab == Lin (newC "A" (newP 1 2)) (newC "B" (newP 0 0)) (newQ "deAaB" 3 0.5),
         
         True]