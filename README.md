# CivilizationArena
Turn based civilization simulation in Java

Arena Cywilizacji jest grą, która gra samą siebie i nie potrzebuje interakcji gracza – jest automatonem.

Przebieg gry:
1. Cywilizacje są małymi, kolorowymi plamami rozmieszczonym losowo na wygenerowanej mapie.
2. Cywilizacje dochodzą do momentu w którym nie ma już wolnej przestrzeni, ich granice się stykają.
3. Cywilizacje zaczynają ze sobą walczyć.

Gra się nie kończy, ale aby ją wygrywać należy:
1. Dominować wojskowo (mieć największą armię → teren i zasoby)
2. Dominować ekonomicznie (mieć najwięcej manufaktur → najwięcej złota)


Spodziewane „końce” gry:
1. Pokój- wszystkie królestwa kończą walczyć w Eonii lub Współczesności
2. Zacofanie – nieustanne wojny nie pozwalają wkroczyć w epokę Eonii

Są następujące kategorie zasobów:
Złoto 
Żywność
Drewno
Skała
Metale
Towary Luksusowe 
Towary Techniczne

Są następujące biomy:
Łąka 	
Las		
Pustka	
Tundra	
Góry	
Woda	
Ocean	

Są następujące jednostki oraz ich koszta:
Wojownik
Strzelec
Mag
Maszyny
Statek

1 Tura – 5 sekund – to 15 lat. 
Cywilizacje podbijają/ rozwijają się/ upadają turami.
Cywilizacja żyła 300 lat – 100 sekund – w turze 21 umiera.

Gra może się rozgrywać dowolnie długo, zatem aby ograniczyć nieograniczony rozwój cywilizacji wprowadzamy czynniki ograniczające:
1. Co 300 lat Cywilizacja umiera – rozpada się na mniejsze Cywilizacje.
2. Jeśli wojna między dwoma Cywilizacjami trwa dłużej niż 30 lat – obie cywilizacje spadają o poziom technologicznie niżej.

Nazwy miast:
Vostomir: Ӝїvnoї
Zapadoslav: Órlohrád 
Jugaria: Ћievljavić

Mechanika gry:
Każda Cywilizacja zaczyna grę mając pewne zasoby, które co turę – z każdą epoką więcej - generuje Twierdza – stolica cywilizacji. 

Koszta działań:
1. Rozszerzenie granic 
2. Jednostki
3. Budynki 

Nagrody działań:
1. Rozszerzenie granic → można budować i zdobywać zasoby
2. Mogą atakować (zdobywać) lub bronić (obrona)
3. Dostęp do zasobów

Zasoby są używane do budowy budynków, które także wytwarzają złoto: 
Farma 
Tartak 
Kamieniołom 
Kopalnia 
Manufaktura  
Fabryka 
