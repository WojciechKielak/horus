# Analiza
W zadaniu są bloki, które są zrobione z określonego materiału i koloru. Blok może składać się z pojedyńczego bloku lub
ze złożonego bloku, który składa się z bloczków, które też mogą składać się zarówno z pojedyńczego bloku jak i ze złożonego 
bloku. Ściana składa się z wielu bloczków, które są umieszczone w liście. Blok złożony może się składać z pojedyńczych 
bloczków lub z kolejnych złożonych bloczków. Założyłem, że bloczek złożony nie ma koloru, pomimo, że interfejs 
CompositeBlock dziedziczy po Block. Ponieważ w bloczku złożonym mogą być pojedyńcze bloczki o różnych kolorach. 
Dlatego aby zwrócić bloczek o danym klorze robijam bloczki złozone na pojedyńcze. Tak samo z materiałem. 

Zaimplementowałem funkcje: count, która zwraca liczbę wszsytkich pojedyńczych bloczków, w przypadku gdy bloczek okaże 
się bloczkiem złożonym to zostanie wywołana funkcja count z parametrem, która rekurencjynie rozbjia zbiór bloczków 
aż do pojedyńczego bloku i je zlicza. Funkcja findBlocksByMaterial zwraca wszsytkie bloczki, które są zrobione z danego 
materiału. W przypadku, gdy bloczek okaże się bloczkiem złożonym to taki bloczek zostaje rozbity rekurencyjnie przy 
pomomocy funkcji findBlocksByMaterial wywołanej z parametrem, aż bloczek zostanie rozpbity do pojedyńczego bloczku. 
Funkcja findBlockByColor zwraca pierwszy napotkany pojedyńczy bloczek o danym kolorze, jeżeli bloczek jest złożony to 
rozbije go na pojedyńcze bloczki rekurencyjnie za pomocą funkcji findBlockByColor z parametrem.
