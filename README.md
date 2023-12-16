# Analiza
W zadaniu są bloki, które są wykonane z określonego materiału i mają określony kolor. Blok może być pojedynczy lub 
złożony. Blok złożony może składać się zarówno z pojedynczych bloków, jak i z innych bloków złożonych. 
Ściana składa się z wielu takich bloków, które są umieszczone w liście. Blok złożony może zawierać pojedyncze bloki 
lub kolejne bloki złożone. Dlatego założyłem, że blok złożony nie posiada określonego koloru, mimo że interfejs 
CompositeBlock dziedziczy po Block. Wynika to z faktu, że w bloku złożonym mogą znajdować się pojedyncze bloki o 
różnych kolorach. Dlatego, aby zwrócić blok o danym kolorze, rozbijam bloki złożone na pojedyncze. Podobnie 
postępuję z materiałem.

Zaimplementowałem funkcję count, która zwraca liczbę wszystkich pojedynczych bloków. W przypadku, gdy blok jest 
blokiem złożonym, funkcja count zostaje wywołana z parametrem, który rekurencyjnie rozbija zbiór bloków aż do 
pojedynczych bloków i je zlicza. Funkcja findBlocksByMaterial zwraca wszystkie bloki wykonane z danego materiału. 
Jeśli blok jest złożony, to zostaje on rozbit rekurencyjnie przy pomocy funkcji findBlocksByMaterial, wywołanej z 
parametrem, aż do osiągnięcia pojedynczych bloków. Funkcja findBlockByColor zwraca pierwszy napotkany pojedynczy 
blok o danym kolorze. Jeżeli blok jest złożony, to jest on rozbijany na pojedyncze bloki rekurencyjnie za pomocą 
funkcji findBlockByColor, wywołanej z parametrem.