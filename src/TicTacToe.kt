import kotlin.math.absoluteValue

/*
* El juego acepta 9 caracteres de intrada con las jugadas de la partida. Las entradas deben ser X, O, _, usando el guió bajo para los espacios vaciós
* */

fun main() {
    var cont = 0
    var x =1
    var y =1
    var juego = ' '
    var estado :String?
    val matriz = generarMatriz()  //Generamos el tablero y dentro del ciclo se modifica la matriz dependiendo de las jugadas
    do{


        if (cont > 0){
            matriz[x-1][y-1] = juego
        }


        val tablero = """
       
        _________
        | ${matriz[0].joinToString(" ")} |
        | ${matriz[1].joinToString(" ")} |
        | ${matriz[2].joinToString(" ")} |
        _________
        """
        println(tablero)

        //Evaluamos el estado del juego, si aún no hay ganador se siguen insertando jugadas
        estado=analizarJuego(matriz)
        if (estado != null){
            println(estado)
            break
        }

        //Verificamos que las coordenadas sean válidas
        var flag = false
        println("Ingresa las coordenadas (x,y): ")
        do{

            x = readln().toInt()
            y = readln().toInt()
            if (x>3 || y>3 || x<=0 || y<=0) println("Ingresa coordenadas válidas. Números del 1 al 3: ")
            else flag = true
        }while(!flag)

        //Verificamos que el turno sea válido
        flag = false
        var juegoAnterior = juego
        println("Marca de jugador (X / O): ")
        do{
            juego = readln().get(0).uppercaseChar()
            if (juego != 'X' && juego != 'O') {
                println("Ingrese caracter válido. Solo se permite 'O' y 'X': ")
            }
            else if(juego == juegoAnterior){
                println("Ya has jugado dos veces. Sigue el turno del contario")
            }
            else flag = true
        }while (!flag)

        cont++


    }while (cont < 9)

    if(cont==9) println("El resultado es un empate")

}



//Generar una matriz 3x3
fun generarMatriz(): MutableList<MutableList<Char>>{
    val lista: MutableList<MutableList<Char>> = mutableListOf()

    for (i in 0..2){
        lista.add(mutableListOf())
        for (j in 0..2){
            lista[i].add('-')
        }
    }

    return lista
}


//Analizamos la partida
fun analizarJuego(mat: MutableList<MutableList<Char>>): String?{

    var result = mutableListOf<Char>()

    //Ya no se necesita el control sobre el número correcto de 'O' y 'X'

    //Verificamos las filas, columnas y diagonales
    if((mat[0][0] == mat[0][1]) && (mat[0][0] == mat[0][2])) result.add(mat[0][0])
    if((mat[1][0] == mat[1][1]) && (mat[1][0] == mat[1][2])) result.add(mat[1][0])
    if((mat[2][0] == mat[2][1]) && (mat[2][0] == mat[2][2])) result.add(mat[2][0])
    if((mat[0][0] == mat[1][0]) && (mat[0][0] == mat[2][0])) result.add(mat[0][0])
    if((mat[0][1] == mat[1][1]) && (mat[0][1] == mat[2][1])) result.add(mat[0][1])
    if((mat[0][2] == mat[1][2]) && (mat[0][2] == mat[2][2])) result.add(mat[0][2])
    if((mat[0][0] == mat[1][1]) && (mat[0][0] == mat[2][2])) result.add(mat[0][0])
    if((mat[0][2] == mat[1][1]) && (mat[0][2] == mat[2][0])) result.add(mat[0][2])


   //Ya no necesitamos verificar que haya solo un ganador

    for (i in result.indices){
        if(result[i] != '-') return "${result[i]} es el ganador"
    }
    return null

}




