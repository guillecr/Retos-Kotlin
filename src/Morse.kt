var code : HashMap<String,String> = hashMapOf(
    "A" to ".-",
    "B" to "-...",
    "C" to "-.-.",
    "D" to "-..",
    "E" to ".",
    "F" to "..-.",
    "G" to "--.",
    "H" to "....",
    "I" to "..",
    "J" to ".---",
    "K" to "-.-",
    "L" to ".-..",
    "M" to "--",
    "N" to "-.",
    "O" to "---",
    "P" to ".--.",
    "Q" to "--.-",
    "R" to ".-.",
    "S" to "...",
    "T" to "-",
    "U" to "..-",
    "V" to "...-",
    "W" to ".--",
    "X" to "-..-",
    "Y" to "-.--",
    "Z" to "..--",
    " " to "\n"
)

fun codeMorse(mensaje : String): String{
    val caracteres = mensaje.split("")
    var salida = ""
    for(c in caracteres){
        salida += if (code[c] != null) code[c] + " " else ""
    }
    return salida
}
fun decodeMorse(mensaje : String): String{
    var salida = ""

    for (c in mensaje.split(" ")){
        for(v in code.filterValues { it == c }.keys)
            salida += v
    }
    return salida
}


// =====================================================================================================================

fun recursiva(mensaje: String, numero : Int, lista : List<Int>, palabras : Set<String>):Set<String>{
    val listTrata = lista.toMutableList()
    val palabrasTrata = palabras.toMutableSet()

    return if(lista.size < numero){

        listTrata.add(listTrata.size,0)
        for(n in 1..4) {
            listTrata[listTrata.size-1] = n
            palabrasTrata.addAll(recursiva(mensaje, numero, listTrata, palabrasTrata))
        }
        palabrasTrata
    }else{
        var test = true
        var cont = 0
        var codeOK = ""
        if(lista.sum() == mensaje.length){
            for(n in lista){
                val c = mensaje.substring(cont,n+cont)
                codeOK += mensaje.substring(cont,n+cont) + " "
                if (code.filterValues { it == c }.keys.isEmpty()) test = false
                cont += n
            }
        }else test = false

        val salida = if(test) decodeMorse(codeOK) else ""
        return setOf(salida)
    }
}

fun funcionLoca(codigoMal : String, numperoPalabras : Int): Set<String>{
    val lista : List<Int> = arrayListOf()
    val palabras : Set<String> = setOf()
    val salida = recursiva(codigoMal,numperoPalabras,lista,palabras).toMutableSet()
    salida.removeIf { it == "" }
    return salida
}

fun main(){
    println("Morse")
    println("Escriba el mensaje")
    val readText = readLine()
    val mensaje = readText.toString().trim().toUpperCase()
    println("El mensaje es $mensaje")
    val morse = codeMorse(mensaje)
    println("El mensaje en morse es: $morse")
    println("Vuelto a traducir:" + decodeMorse(morse))
    val morseMal = morse.replace(" ", "")
    val palabras = funcionLoca(morseMal,mensaje.length)
    println("El codigo sin espacios es $morseMal, que daria como opciones: ")
    for(p in palabras)
        println("\t - $p")
}