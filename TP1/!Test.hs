import Tunel
import Link
import Point
import Quality
import Region
import City

point1 = newP 1 2
point2 = newP 0 0
point3 = newP 3 4
point4 = newP 5 4
city1 = newC "Vice City" point1
city2 = newC "Liberty City" point2
city3 = newC "Los Santos" point3
city4 = newC "San Andres" point4

cobre = newQ "cobre" 3 0.5
viceToLiberty = newL city1 city2 cobre
libertyToSantos = newL city2 city3 cobre
tunel = newT [viceToLiberty, libertyToSantos]
reg0 = newR
reg1 = foundR reg0 city1
reg2 = foundR reg1 city2
reg3 = foundR reg2 city3
reg4 = foundR reg3 city4
reg5 = linkR reg4 city1 city2 cobre
reg6 = linkR reg5 city2 city3 cobre
reg7 = linkR reg6 city3 city4 cobre
reg8 = tunelR reg7 [city1, city2, city3]

test = [difP point1 point2 == sqrt 5,
        nameC city1 == "Vice City",
        distanceC city1 city2 == sqrt 5,
        capacityQ cobre == 3,
        delayQ cobre == 0.5,
        connectsL city1 viceToLiberty,
        linksL city3 city2 libertyToSantos,
        capacityL viceToLiberty == 3,
        delayL viceToLiberty == 0.5,
        connectsT city3 city1 tunel,
        usesT libertyToSantos tunel,
        delayT tunel == 1,
        connectedR reg8 city1 city3,
        linkedR reg5 city1 city2,
        delayR reg8 city1 city3 == 1,
        availableCapacityForR reg8 city1 city3 == 2,
        True]