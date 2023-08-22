module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ name tunnels delay = Qua name tunnels delay

capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua _ tunnels _) = tunnels

delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua _ _ delay) = delay

test = [ newQ "deAaB" 3 0.5 == Qua "deAaB" 3 0.5,
         capacityQ (Qua "deAaB" 3 0.5) == 3,
         delayQ (Qua "deAaB" 3 0.5) == 0.5,
         True]