module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links = Tun links

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun ls) = (connectsL city1 (head ls) && connectsL city2 (last ls)) || connectsL city1 (last ls) && connectsL city2 (head ls)

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun ls) = elem link ls

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (l:ls)) = delayL l + delayT (Tun ls)