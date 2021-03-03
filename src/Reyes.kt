import kotlin.math.pow

fun romanoNumbre(numero : Int): String{
    var trata = numero
    var salida = ""
    var rep = 0
    var letraOld = ""
    var letra : String
    val letras = arrayListOf("I","V","X","L","C","D","M")

    while (trata > 0) {
        letra = letras[0]
        when {
            trata % 1000 == 0 -> {
                trata -= 1000
                letra = letras[6]
            }
            trata % 500 == 0 -> {
                trata -= 500
                letra = letras[5]
            }
            trata % 100 == 0 -> {
                trata -= 100
                letra = letras[4]
            }
            trata % 50 == 0 -> {
                trata -= 50
                letra = letras[3]
            }
            trata % 10 == 0 -> {
                trata -= 10
                letra = letras[2]
            }
            trata % 5 == 0 -> {
                trata -= 5
                letra = letras[1]
            }
            else -> {
                trata -= 1
            }
        }

        if(letra == letraOld) rep++
        else rep = 0
        letraOld = letra
        if(rep>2 && letra != "M"){
            rep = 0
            val indice = letras.indexOf(letra)
            var subletra = letra + letras[indice+1]
            val factor = 10.toDouble().pow(indice/2).toInt()
            if(trata > 0 && (trata%2 != 0 || (trata/factor)%2 != 0)){
                trata -= 5 * factor
                subletra = letra+letras[indice+2]
            }
            salida = subletra + salida.substring(3)
        }
        else salida = letra + salida
    }
    return salida
}


fun main() {
    var reyes: HashMap<String, Int> = hashMapOf(
        "Pedro" to 4,
        "Alfonso" to 13,
        "Carlos" to 5,
        "Isabel" to 2,
        "Marina" to 4,
        "Juan" to 2,
        "Juan Carlos" to 1,
        "David" to 3
    )
    var nombre: String = ""
    while (nombre.toLowerCase() != "poroto") {
        println("Indique el nombre del rey")
        nombre = readLine().toString()
        if (reyes[nombre] != null) reyes[nombre] = reyes[nombre].hashCode() + 1 else reyes[nombre] = 1
        val resultado = romanoNumbre(reyes[nombre].hashCode())
        println("$nombre $resultado")
    }
}