# CivilizationArena
Symulacja turowej gry cywilizacyjnej w Javie.
Używając dalej słowa "cywilizacji" mamy na myśli agenty klasy Cywilizacja używającej różnych 
atrybutów i innych klas, natomiast słowo "gra" używane jest tożsamo z symulacją.

Przebieg gry:
1. Cywilizacje są małymi, kolorowymi plamami rozmieszczonym losowo na wygenerowanej mapie.
2. Cywilizacje dochodzą do momentu w którym nie ma już wolnej przestrzeni, ich granice się stykają.
3. Cywilizacje zaczynają ze sobą walczyć.

Gra się nie kończy, ale aby ją wygrywać należy:
1. Dominować wojskowo (mieć największą armię → teren i zasoby)
2. Dominować ekonomicznie (mieć najwięcej budynków → najwięcej złota)

Są następujące kategorie zasobów:
Złoto 
Żywność
Drewno
Skała
Metale
Towary Luksusowe 
Towary Techniczne

Są następujące biomy, zasoby które oferują i budynki do ich pozyskania:
Łąka 	 → Farma → Żywność
Las		 → Tartak → Drewno
Pustka → Manufaktura  → Towary Luksusowe lub Pustka → Fabryka → Towary Techniczne
Tundra → Manufaktura  → Towary Luksusowe lub Tundra → Fabryka → Towary Techniczne
Góry	 → Kopalnia → Metal lub Góry → Kamieniołom → Kamień
Woda	 → Łowisko → Żywność
Ocean	 → Łowisko → Żywność
W sytuacji gdzie z pewnego powodu nie można wyprodukować jakiegoś zasobu można go wymienić za złoto 
(stale generowane przez Twierdzę i budowle)

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

Rozróżniamy 3 główne działania cywilizacji, ich koszty i nagrody:
1. Rozszerzenie granic (złoto) → można budować i zdobywać zasoby
2. Jednostki (złoto, zasoby) → Mogą atakować (zdobywać) lub bronić (obrona)
3. Budynki (złoto, zasoby) → produkują zasoby

Przykładowe nazwy miast cywilizacji:
Vostomir: Ӝїvnoї, Orshaў, Чelyagrad
Zapadoslav: Órlohrád, Tarnavčín, Lípovice
Jugaria: Ћievljavić, Gostiш, Џžice

Gra będzie rozgrywana na sachownicy o rozmiarze w zakresie 4x4 do 24x24.

Warunki początkowe gry:
- ilość cywilizacji
- wielkość mapy
- ilość zasobów (nie każdy biom np. typu łąka)
- ilość zasobów początkowych (ile złota, ... ma na początku Twierdza)

Modyfikowalne warunki w czasie gry:
-ile trwa cywilizacja

Dane szczytywane z gry od każdej cywilizacji:
- ile ma terenu (kwadratów) i jakie biomy (procentowo)
- ile zasobów każdego typu
- ilość żołnierzy każdego typu
- ile istnieje dana cywilizacja ( każda ma żywotność 300 ± 45 lat)
- ile lat trwa sama gra (od początku)

Pomijamy populację jako czynnik w symulacji uznając, że rozrasta się wraz z rozszerzaniem granic i budowaniem budowli
Zwracamy szczególnie uwagę na czynniki ekonomiczne i wojskowe symulacji
Decyzje będą podejmowane przez cywilizacje na podstawie rachunku zysków do 3 tur do przodu
(np. jeśli nie mamy granicy z sąsiadem, bardziej opłaca się rozszerzyć granicę i zdobyć na niej zasób niż 
rekrutować z Twierdzy nową jednostkę)
Jednostki wojskowe są rekrutowane tylko w Twierdzy (możliwe że dodamy Koszary)

Gra rozgrywa się turami, więc budowanie lub przejmowanie terytorium wroga dzieli się na kroki trwające 1 turę każda:
1. Poszerzenie terytorium → zbudowanie budowli → dopiero teraz zaczyna produkować zasoby i złoto
lub
2. Wejście jednostki na terytorium wroga → zburzenie jego budowli → poszerzenie granicy
