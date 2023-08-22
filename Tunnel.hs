module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun link c1 c2) | ((city1 == c1) && (city2 == c2)) || ((city1 == c2) && (city2 == c1)) = True
                                       | otherwise = False

-- por que connectsT me dice que si el tunel atraviesa las 2 ciudades, y la usesT si atraviesa el link?
-- el tunel solo toma un link como input, no se donde existe que un tunel que tome el link x no pase por el link x
-- como mas puedo buscar un tunel entre 2 ciudades mas que usando el link de esas 2 ciudades como input de tunel?

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link1 (Tun link2) | link1 == link2 = True
                        | otherwise = False

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel