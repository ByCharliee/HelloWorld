
fun main(){

    print("Esta es la nueva línea de código")

    var opcion: Int
    do{
        val entrada = entradaUsuario()
        opcion = analizarTexto(entrada)
        println(responder(opcion))
    }while(opcion != 4)

}

//Lee el texto del usuario
fun entradaUsuario(): String = readln()

//Arroja una respuesta dependiendo de la entrada
fun responder(entrada: Int): String{

    return when(entrada){
        1 -> "¡Hola!, ¿en que puedo ayudarte?"
        2 -> "Puedo responder un saludo, decirte como estoy o despedirme"
        3 -> "Estoy muy bien, ¡Gracias por preguntar!"
        4 -> "¡Hasta pronto!"
        else -> "Lo siento, no entiendo. ¿Puedes preguntar de otra forma?"

    }
}

//Analiza el input del usuario
fun analizarTexto(texto: String): Int{
        if(texto.lowercase().contains("hola")) return 1
        else if (texto.lowercase().contains("que puedes hacer")) return 2
        else if(texto.lowercase().contains("como estas")) return 3
        else if(texto.lowercase().contains("adios")) return  4
        else return 5


}