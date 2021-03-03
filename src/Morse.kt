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

fun recursiva(numero : Int, cont : Int):String{
    return if(cont > 0){
        var salida = ""
        for(n in 1..numero)
            salida += ""+n + " + " + recursiva(numero,cont-1)
        salida
    }else{
        "\n"
    }
}

fun decodeMorseA(mensaje : String, palabras : Int): String{
    var lista : String
    var sizeM = mensaje.length
    var max = palabras*4
    //num = sizeM/palabras



    return recursiva(4,4)
}

fun main(){
    println(recursiva(4,4))
}

/*
fun main(){
    println("Morse")
    println("Escriba el mensaje")
    var mes = readLine()
    var mensaje = mes.toString().trim().toUpperCase()
    println("El mensaje es $mensaje")
    var traducido = codeMorse(mensaje)
    println("El mensaje traducido es: $traducido")
    print(decodeMorse(traducido))
}
 */