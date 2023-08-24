module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun links) | distanceC city1 city2 == 0 = error "El túnel no puede conectar una ciudad con sí misma."
                                  | (connectsL city1 (head links) && connectsL city2 (last links)) || connectsL city1 (last links) && connectsL city2 (head links) = True
                                  | otherwise = False

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) | elem link links = True
                       | otherwise = False

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (l:ls)) = delayL l + delayT (Tun ls)
