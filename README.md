# Sistema de Impresión 3D

Programa de consola en Java que calcula el costo de pedidos de impresión 3D
(energía, filamento, desgaste de máquina y mano de obra) y lleva el resumen del día.
Proyecto de Programación Orientada a Objetos 2026-2, Universidad Nacional de Colombia.

## Integrantes
- Samuel Felipe Yara Lopez
- Maria Lucia Moncaleano Mutis
- Samuel Alejandro Tellez Luna
- Miguel Angel Garzon Bohorquez
- Yohan Esteban Sanchez Camacho

## Cómo correr el programa

### Paso 1. Verificar que Java esté instalado
Abrir una terminal (en Windows: tecla Windows, escribir cmd y Enter) y escribir:

    javac -version

Si muestra una versión 17 o superior (por ejemplo `javac 21.0.2`), pasar al paso 2.
Si dice que el comando no se reconoce, instalar el JDK 17 o superior
(por ejemplo Temurin, desde https://adoptium.net) y reiniciar la terminal.

### Paso 2. Descargar el código
1. En la página del repositorio, pulsar el botón verde **Code** y luego **Download ZIP**.
2. Descomprimir el ZIP en una carpeta cuyo nombre no tenga espacios
   (por ejemplo `C:\ProyectoPOO`).

### Paso 3. Abrir una terminal dentro de la carpeta `src`
1. Entrar a la carpeta descomprimida y abrir la carpeta `src`
   (debe contener los archivos `.java`).
2. Hacer clic en la barra de direcciones del Explorador de archivos,
   escribir `cmd` y pulsar Enter. Se abre una terminal ya ubicada en `src`.

### Paso 4. Compilar y ejecutar
Escribir estos dos comandos, uno por uno, pulsando Enter después de cada uno:

    javac *.java
    java Main

El primero compila (si no muestra mensajes, salió bien) y el segundo inicia el programa.
Debe aparecer el menú «SISTEMA DE IMPRESIÓN 3D». Para usarlo, escribir el número de la
opción en la misma terminal y pulsar Enter.

### Alternativa: ejecutar desde un IDE
Abrir la carpeta del proyecto en VS Code (con la extensión Java), IntelliJ IDEA o
NetBeans y ejecutar la clase `Main`.

### Problemas frecuentes
- «javac no se reconoce»: el JDK no está instalado o hay que reiniciar la terminal.
- «Could not find or load main class Main»: la terminal no está en la carpeta `src`
  o no se ejecutó antes `javac *.java`.
- Errores raros de `javac`: revisar que ninguna carpeta de la ruta tenga espacios
  al final del nombre.

## Funcionalidades (Entrega 1)
- Registrar un nuevo pedido con varias placas.
- Cotizar un pedido y decidir si se registra.
- Ver el resumen del día (pedidos atendidos y total vendido).

## Reglas de cobro
- Energía: $2.000 por kW, con un consumo de 0,3 kW por hora de impresión.
- Filamento: $100 por gramo, cobrado solo si el usuario lo activa en el pedido.
- Desgaste de máquina: $6.000 por placa.
- Mano de obra: $3.000 por hora de impresión.
- Recargo por uso: $5.000 por cada 10 placas completas del pedido.
- El total se redondea hacia arriba a la centena más cercana.

## Validaciones de entrada
- Cantidad de placas: número entero entre 1 y 20.
- Cobrar filamento: solo 1 (Sí) o 2 (No).
- Tiempo de impresión: número entero entre 1 y 600 minutos.
- Peso de la pieza: mayor que 0 y máximo 750 g por placa.
- Si el usuario escribe letras o un valor fuera de rango, el programa lo avisa y
  vuelve a preguntar.
- Menú principal: solo opciones 1 a 4; cualquier otra entrada muestra
  «Opción no válida» y vuelve a mostrar el menú.
- Al cotizar: solo 1 (Sí) o 2 (No); cualquier otra respuesta no registra el pedido.
- Los decimales (peso) se escriben con el formato del sistema (coma o punto).

## Estructura
- `src/`: código fuente (`Main`, `CrearPedido`, `Pedido`, `Placas`, `Energia`, `Material`, `ResumenDia`).
- `docs/`: diagrama UML.

