
class Coche(var color: String, var peso: Int){

    //Verificar que el peso no sea negativo o nulo
    init {
        if(peso<=0){
            println("El peso no es válido, se le asignará el peso por defecto")
            peso = 1500
        }
    }

    //Constructor secundario
    constructor(color: String): this(color, 1500)

    //Atributos con valor inicial
    var tamano = "Grande"
    var modelo = "2005"


    //Métodos: Acciones que puede realizar el objeto
    fun girar(){
        println("el coche está girando")
    }

    fun encender(){
        println("el coche está encendido")
    }


}





fun main(){

    val miCoche1 = Coche("Azul", 1250)
    val miCoche2 = Coche("Negro", -647)
    val miCoche3 = Coche("Blanco")  // objeto creado llamando al constructor secundario

    miCoche1.encender()
    miCoche1.girar()

    println("El peso del coche 2 es ${miCoche2.peso}")
    println("El peso del coche 3 es ${miCoche3.peso}")
}