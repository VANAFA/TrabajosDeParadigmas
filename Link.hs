module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin c1 c2 _) | (city == c1) || (city == c2) = True
                             | otherwise = False

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 (Lin c1 c2 _) | ((city1 == c1) || (city1 == c2)) && ((city2 == c1) || (city2 == c2)) = True
                                 | otherwise = False

capacityL :: Link -> Int
capacityL (Lin _ _ qua) = capacityQ qua

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin _ _ qua) = delayQ qua