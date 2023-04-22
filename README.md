# CivilizationArena
Turn based civilization simulation in Java

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
Wojownik (drewno, metale)
Strzelec (drewno, metale)
Mag (towary luksusowe, metale)
Maszyny (towary techniczne, metale)
Statek (towary techniczne, drewno)

Mechanika gry:
Każda Cywilizacja zaczyna grę mając pewne zasoby. Co turę Twierdza – stolica cywilizacji - generuje złoto,
a budynki produkują przypisane sobie zasoby. 

1 Tura – 10 sekund – to 15 lat. 
Cywilizacje podbijają/ rozwijają się/ upadają turami.
Cywilizacja żyje 300 ± 45 lat –> 200 ± 30 sekund – w turze 21 ± 3 umiera,
wszystkie budowle tej cywilizacji i granice znikają. Losowo może powstać 0, 1 lub 2 cywilizacje,
które będą miały twierdze losowo w miejscach, gdzie stały inne budynki.

Nazwy miast:
Vostomir: Ӝїvnoї, Orshaў, Чelyagrad
Zapadoslav: Órlohrád, Trnavčín, Lípovice
Jugaria: Ћievljavić, Gostiш, Џžice

Koszta działań:
1. Rozszerzenie granic (złoto)
2. Jednostki (złoto, zasoby)
3. Budynki (złoto, zasoby)

Nagrody działań:
1. Rozszerzenie granic → można budować i zdobywać zasoby
2. Mogą atakować (zdobywać) lub bronić (obrona)
3. Dostęp do zasobów

Zasoby są używane do budowy budynków, które także wytwarzają złoto: 
Farma -> Żywność
Tartak -> Drewno
Kamieniołom -> Kamień
Kopalnia -> Metal
Manufaktura  -> Towary Luksusowe
Fabryka -> Towary Techniczne
