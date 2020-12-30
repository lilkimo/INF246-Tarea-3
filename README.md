# Integrantes
Camilo Gonzalez, 201873550-7

Zarko Kuljis, 201823523-7

Obtuvimos un 90, se nos descontó 10 puntos por no comentar el código.
# Consideraciones
* Los decimales se escribirán con punto (.).
* El nombre de cada función sólo será de 1 caracter alfabético.
* Cada función recibirá sólo 1 parámetro.
* El nombre del parámetro será de 1 sólo caracter alfabético.
* Las operaciones se ejecutaran de izquierda a derecha. Ejemplo: `2*5/3 == (2*5)/3`
* El cuerpo de una función (Sea f(x)=y, 'y' es el cuerpo) no contendrá funciones anidadas. Ej:
    * f(x) = g(x) + h(x) :heavy_check_mark:
    * f(x) = g(h(x)) :x:
    * f(x) = g(x*3+7) :heavy_check_mark:

# Resultados
## Desiciones tomadas
Al principio para evitar un algoritmo confuso y con muchos casos particulares tomamos la desición de, ya que el algoritmo quicksort divide por mitades el arreglo, crear un thread por cada una de esas mitades.
## Conclusión
Nuestra implementación de threads no beneficia al algoritmo, puesto que creamos un thread por cada mitad, y luego un thread por cada mitad de la mitad y así hasta llegar a un sólo elemento. Creando más threads que elementos, viendonos perjudicados principalmente por el tiempo de creación, eliminación e itineración de las threads.
