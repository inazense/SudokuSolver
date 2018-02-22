# SudokuSolver
Solucionador de Sudokus.

__*Versión 1.1*__

<p align="center">
  <img src="/resources/img/logo.png">
</p>

#### Explicación
Programa que solventa sudokus introducidos por el usuario.
En la versión actual lee una matriz de 9x9 de enteros como la siguiente:

{ 8, 3, 2, 7, 0, 6, 0, 5, 4 }

{ 0, 6, 5, 0, 3, 8, 7, 9, 2 }

{ 7, 0, 4, 5, 2, 0, 0, 0, 0 }

{ 0, 1, 8, 9, 7, 4, 3, 0, 5 }

{ 9, 4, 0, 2, 8, 5, 6, 0, 0 }

{ 5, 2, 7, 0, 1, 0, 0, 4, 8 }

{ 0, 0, 0, 0, 4, 0, 5, 0, 0 }

{ 0, 0, 0, 0, 0, 9, 0, 0, 3 }

{ 3, 0, 6, 1, 5, 0, 4, 8, 9 }

y trata de resolverla, para posteriormente imprimir el resultado por pantalla o mostrar una advertencia en caso de que no haya podido soluciar el Sudoku.

<p align="center">
  <img src="/resources/img/ejemplo1.png">
</p>

#### Cargar sudoku
Si quieres cargar tu propio sudoku, tienes que generar un .csv con valores del 0 al 9 (0 casilla vacía), separado por comas y sin espacios, como se puede ver en el siguiente ejemplo:

8,3,2,7,0,6,0,5,4

0,6,5,0,3,8,7,9,2

7,0,4,5,2,0,0,0,0

0,1,8,9,7,4,3,0,5

9,4,0,2,8,5,6,0,0

5,2,7,0,1,0,0,4,8

0,0,0,0,4,0,5,0,0

0,0,0,0,0,9,0,0,3

3,0,6,1,5,0,4,8,9

Una vez hecho, carga el programa que te preguntará por la ruta del fichero (es indiferente si la escribes absoluta o relativa) y comenzará el proceso de resolución del sudoku. 

#### Funcionamiento
Realiza la siguiente interpretación:
- 0 = Casilla vacía. Es la que el programa buscará para rellenar su valor
- De 1 a 9 = Valor fijo preestablecido por el usuario. La leerá para realizaz sus cálculos pero nunca modificará su valor.

La lógica que sigue es la de la aplicación de fuerza bruta. Recorre las casillas editables y comprueba, de 1 a 9, que ese valor encaja con la fila, columan y sección correspondientes. En caso de encajar, avanza hacía la siguiente casilla.
Si el número no puede estar en esa posición, incrementamos hasta el valor 9 y, en caso de que tampoco encaje, retrocedemos una casilla incrementando el valor de la misma en uno. Así hasta conseguir completar el sudoku o llegar a la casilla [0,0] de la matriz con un valor superior a 9, lo que signifca la irresolución del sudoku.
