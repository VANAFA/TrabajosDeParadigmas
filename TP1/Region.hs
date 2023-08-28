module Region ( Region, newR, foundR, linkR, tunelR, pathR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Quality
import Link
import City
import Tunel

data Region = Reg [City] [Link] [Tunel] deriving (Eq, Show ) --sacar el deriving show

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cs ls ts ) city = Reg (city:cs) ls ts

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cs ls ts ) city1 city2 qua | distanceC city1 city2 == 0 = error "Una ciudad no puede tener un link con sí misma."
                                      | not (elem city1 cs && elem city2 cs) = error "Las 2 ciudades deben de estar en la región."
                                      | otherwise = Reg cs (newL city1 city2 qua : ls) ts

pathR :: Region -> [ City ] -> [ Link ]
pathR (Reg cs ls ts) (city:cities) | null cities = []
                                   | otherwise = [l | l <- ls, linksL city (head cities) l] ++ pathR (Reg cs ls ts) cities

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región                             
tunelR (Reg cs ls ts) cities = Reg cs ls (newT (pathR (Reg cs ls ts) cities) : ts)

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ ts) city1 city2  = not $ null [t | t <- ts, connectsT city1 city2 t]

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ ls _ ) city1 city2 = not $ null [l | l <- ls, linksL city1 city2 l]

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg _ ls ts ) city1 city2 = sum listTs / fromIntegral (length listTs) 
                                 where listTs = [delayT t | t <- ts, connectsT city1 city2 t]

usedCapacityForR :: Region -> City -> City -> Int 
usedCapacityForR (Reg _ _ ts) city1 city2 = length [t | t <- ts, connectsT city1 city2 t]

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cs ls ts) city1 city2 = minimum [capacityL l | l <- pathR (Reg cs ls ts) [city1, city2]] - usedCapacityForR (Reg cs ls ts) city1 city2