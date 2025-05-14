import kotlin.math.absoluteValue

fun main() {
    val juego = readln()
    val matriz = convertirMatriz(juego)
    val tablero = """
        > $juego
        _________
        | ${matriz[0].joinToString(" ")} |
        | ${matriz[1].joinToString(" ")} |
        | ${matriz[2].joinToString(" ")} |
        _________
    """
    println(tablero)


    println( analizarJuego(matriz))





}


//Convertir la cadena en una matriz 3x3
fun convertirMatriz(cad: String): MutableList<MutableList<Char>>{
    val lista: MutableList<MutableList<Char>> = mutableListOf()
    var cont = 0

    for (i in 0..2){
        lista.add(mutableListOf())
        for (j in 0..2){

            var car = cad[cont]
            lista[i].add(car)
            cont++

        }
    }

    return lista
}


//Analizamos la partida
fun analizarJuego(mat: MutableList<MutableList<Char>>): String{

    var result = 'z'//Valor de control
    var cont = 0 //para verificar que solo haya un ganador
    var x = 0
    var o = 0

    //revisar que exista el número correcto de O y X
    for (i in mat.indices){
        for (j in mat.indices){
            if (mat[i][j] == 'X')x++
            if (mat[i][j] == 'O')o++

        }
    }

    if ((x-o).absoluteValue > 1) return "Imposible"


    //Verificamos las filas, columnas y diagonales
    if((mat[0][0] == mat[0][1]) && (mat[0][0] == mat[0][2])) {result=mat[0][0]; cont++}
    if((mat[1][0] == mat[1][1]) && (mat[1][0] == mat[1][2])) {result=mat[1][0]; cont++}
    if((mat[2][0] == mat[2][1]) && (mat[2][0] == mat[2][2])) {result=mat[2][0]; cont++}
    if((mat[0][0] == mat[1][0]) && (mat[0][0] == mat[2][0])) {result=mat[0][0]; cont++}
    if((mat[0][1] == mat[1][1]) && (mat[0][1] == mat[2][1])) {result=mat[0][1]; cont++}
    if((mat[0][2] == mat[1][2]) && (mat[0][2] == mat[2][2])) {result=mat[0][2]; cont++}
    if((mat[0][0] == mat[1][1]) && (mat[0][0] == mat[2][2])) {result=mat[0][0]; cont++}
    if((mat[0][2] == mat[1][1]) && (mat[0][2] == mat[2][0])) {result=mat[0][0]; cont++}


    //verficar solo un ganador
    if (cont >= 2) return "Imposible"


    if (result == 'z'){
        //revisamos que el juego ya esté terminado
        for (i in mat.indices){
            if (mat[i].contains('_')){
                return "Juego aún no terminado"
            }

        }

        //Si ya está terminado y no hay ganador entonces es un empate
        return "Empate"

    }

    return "$result ganó la partida"




}




