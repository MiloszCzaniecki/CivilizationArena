# CivilizationArena
Turn based civilization simulation in Java
Arena Cywilizacji
„Arena Cywilizacji” jest grą, która gra samą siebie i nie potrzebuje interakcji gracza – jest automatonem.

Przebieg gry:
1. Cywilizacje są małymi, kolorowymi plamami rozmieszczonym losowo na wygenerowanej mapie.
2. Cywilizacje dochodzą do momentu w którym nie ma już wolnej przestrzeni, ich granice się stykają.
3. Cywilizacje zaczynają ze sobą walczyć.

Gra się nie kończy, ale aby ją wygrywać należy:
1. Dominować wojskowo (mieć największą armię → teren i zasoby)
2. Dominować ekonomicznie (mieć najwięcej manufaktur → najwięcej złota)
3. Dominować technologiczniey

Spodziewane „końce” gry:
1. Pokój- wszystkie królestwa kończą walczyć w Eonii lub Współczesności
2. Anihilacja – wszystkie królestwa niszczą się Bombą
3. Zacofanie – nieustanne wojny nie pozwalają wkroczyć w epokę Eonii

Są następujące epoki:
Antyk
Renesans
Oświecenie
Współczesność
Eonia

Są następujące kategorie zasobów:
Złoto (uzyskiwane z wojen, budynków)
Żywność
Drewno
Skała
Metale
Towary Luksusowe (miód, len...)
Towary Techniczne (żywica, nici..)

Są następujące biomy:
Łąka 	
Las		
Pustka	
Tundra	
Góry	
Woda	
Ocean	

Są następujące jednostki oraz ich koszta:
Wojownicy: pikier → rycerz → szablarz → agent → assassin
1 zł → 2 zł → 3 zł → 4 zł → 5 zł

Strzelcy: łucznik → kusznik → muszkieter → sniper → boyevnik
2 zł → 4 zł → 6 zł → 8 zł → 10 zł

Magowie: wysłannik → mag → alchemik → łamacz → carnifex 
3 zł → 6 zł → 9 zł → 12 zł → 15 zł

Maszyny: wóz bojowy → czołg Da Vinci’ego → taran parowy → czołg → anihilator
5 zł → 10 zł → 15 zł → 20 zł → 25 zł

Marynarka: łódź → statek → okręt → niszczyciel → destruktor
5 zł → 10 zł → 15 zł → 20 zł → 25 zł

1 Tura – 5 sekund – to 15 lat. 
Cywilizacje podbijają/ rozwijają się/ upadają turami.
Cywilizacja żyła 300 lat – 100 sekund – w turze 21 umiera.

Gra może się rozgrywać dowolnie długo, zatem aby ograniczyć nieograniczony rozwój cywilizacji wprowadzamy czynniki ograniczające:
1. Co 300 lat Cywilizacja umiera – rozpada się na mniejsze Cywilizacje.
2. Jeśli wojna między dwoma Cywilizacjami trwa dłużej niż 30 lat – obie cywilizacje spadają o poziom technologicznie niżej.
3. Istnieją najwyższe etapy rozwoju poszczególnych dziedzin Cywilizacji w najpóźniejszej epoce - Eonia – cywilizacje nie mogą się rozwijać bardziej poza ten etap (rzadko osiągany).

Nazwy miast:
Vostomir: Ӝїvnoї
Zapadoslav: Órlohrád 
Jugaria: Ћievljavić

Mechanika gry:
Każda Cywilizacja zaczyna grę mając 5 złota, które co turę – z każdą epoką więcej - generuje Twierdza – stolica cywilizacji. 

Koszta działań:
1. Rozszerzenie granic → 1 zł
2. Jednostki
3. Manufaktury 

Nagrody działań:
1. Rozszerzenie granic → można budować i zdobywać zasoby
2. Mogą atakować (zdobywać) lub bronić (obrona)
3. Dostęp do zasobów

Zasoby są używane do budowy budynków, które także wytwarzają złoto: 
Farma 6
Tartak 4
Kamieniołom 3
Kopalnia 3
Manufaktura 2 (miód, len…) 
Fabryka 2 (żywica, nici..)

Są jednak ograniczenia w ich budowie według proporcji (przeciwdziała sytuacjom gdzie nie ma farm a są same manufaktury towarów luksusowych). 6 : 4 : 3 : 3 : 2 : 2, proporcji fizycznie nie można przekroczyć (blokada budynków). (Możliwie będzie inaczej dla każdej epoki).
