# Retos en Kotlin

## Reyes
En la historia de la familia real, estos son los últimos Reyes que han reinado.
Pedro IV, Alfonso XIII, Carlos V, Isabel II, Maria IV, Juan II, Juan Carlos I y David III.

El programa recibirá el nombre y debe dar como respuesta el nombre con su ordinal correcto. Si el nombre no ha sido aún usado para ningún rey, debe devolver ese nombre con el ordinal I (primero).

## Morse
Llegan las fiestas de fin de año y nos llegan telegramas de felicitación en código morse…
esto nos pasa por tener amigos muy frikis. El problema es que los telegramas se han
enviado en código Morse y sin espacios entre las diferentes letras del mensaje.
En el código Morse, cada letra del alfabeto se sustituye por una secuencia de puntos y
guiones de la siguiente manera:
a .- h .... o --- v ...-
b -... i .. p .--. w .--
c -.-. j .--- q --.- x -..-
d -.. k -.- r .-. y -.--
e . l .-.. s ... z --..
f ..-. m -- t -
g --. n -. u ..-

Se usan todas las combinaciones de entre 1 y 4 puntos y guiónes, a excepción de:
..-- .-.- ---. ----
Si los espacios entre las letras se pierden, los mensajes pueden ser ambiguos. Por
ejemplo, incluso si sabemos que el mensaje -..-----. se compone de tres letras, aún podría
significar: njg, dog, xmg o xon.
Escribe un programa que lea en un mensaje (entre 1 y 10 letras inclusive) y determine la
cantidad de mensajes con el mismo número de letras que podría representar en morse ya
que no se tiene claro hasta donde llega cada letra en esta codificación. Muestre además
los mensajes que se pueden construir con la secuencia de puntos y guiónes recibidos.
