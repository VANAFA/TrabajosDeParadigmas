module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP x y = Poi x y

difP :: Point -> Point -> Float  -- distancia absoluta
difP (Poi x1 y1) (Poi x2 y2) = sqrt $ fromIntegral $ (x1 - x2)^2 + (y1 - y2)^2

point1 = newP 1 2
point2 = newP 0 0

test = [ point1 == Poi 1 2,
         difP point1 point2 == sqrt 5,
         True]