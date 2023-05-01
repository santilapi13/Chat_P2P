#Diseño e implementación de un sistema de mensajería instantánea.
Este sistema permitirá a los usuarios, intercambiar entre ellos, pequeños mensajes de
texto.
Algunas características para tener en cuenta
1) Una vez iniciada una sesión entre dos usuarios, los mismos pueden intercambiar
toda la cantidad de mensajes que quieran hasta que uno de los dos participantes
cierre la sesión.

2) Para iniciar un diálogo, el receptor debe estar en modo escucha. Es decir, a la
espera de que otro usuario quiera establecer el diálogo con el.

3) Solo se permite una única sesión en simultáneo. Un usuario no puede tener más
de un diálogo a la vez.

4) Para comenzar una sesión, el usuario iniciador debe ingresar la dirección IP y
puerto que corresponde al usuario con el que quiere establecer el diálogo.

5) El sistema respetará el estilo de arquitectura Peer to Peer.

Para esta iteración, no se provee ningún tipo de persistencia.
El sistema será construido con interfaces de usuario gráfica y como aplicación de
escritorio para entorno Windows/Linux.
Se utilizará el lenguaje Java para la codificación.
