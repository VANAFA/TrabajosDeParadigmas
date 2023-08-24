module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where
-- pathR, linksForR, usedCapacityForR (for my use)
import Quality
import Tunel
import City 
import Link 

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cs ls ts ) city = Reg (city:cs) ls ts

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cs ls ts ) city1 city2 qua | distanceC city1 city2 /= 0 = error "Una ciudad no puede tener un link con sí misma."
                                      | not (elem city1 cs && elem city2 cs) = error "Las 2 ciudades deben de estar en la región."
                                      | otherwise = Reg cs ((newL city1 city2 qua):ls) ts



-- temp, only for testing
tunelR :: a -> a
tunelR a = a
connectedR :: a -> a
connectedR a = a
linkedR :: a -> a
linkedR a = a
delayR :: a -> a
delayR a = a
availableCapacityForR :: a -> a
availableCapacityForR a = a

{-
tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
-}