# Sistema de Impresión 3D

Programa de consola en Java que calcula el costo de pedidos de impresión 3D
(energía, filamento, desgaste de máquina y mano de obra), lleva el resumen del día
y organiza la agenda semanal de la impresora.
Proyecto de Programación Orientada a Objetos 2026-2, Universidad Nacional de Colombia.

## Integrantes
- Samuel Felipe Yara Lopez
- Maria Lucia Moncaleano Mutis
- Samuel Alejandro Tellez Luna
- Miguel Angel Garzon Bohorquez
- Yohan Esteban Sanchez Camacho

## Cómo correr el programa

### Paso 1. Verificar que Java esté instalado
Abrir una terminal (en Windows: tecla Windows, escribir `cmd` y Enter) y escribir:

    javac -version

Si muestra una versión 17 o superior, pasar al paso 2. Si dice que el comando no se
reconoce, instalar el JDK 17 o superior (por ejemplo Temurin, desde https://adoptium.net)
y reiniciar la terminal.

### Paso 2. Descargar el código
1. En la página del repositorio, pulsar el botón verde **Code** y luego **Download ZIP**.
2. Descomprimir el ZIP en una carpeta cuyo nombre no tenga espacios
   (por ejemplo `C:\ProyectoPOO`).

### Paso 3. Abrir una terminal dentro de la carpeta `src`
1. Entrar a la carpeta descomprimida y abrir la carpeta `src` (debe contener las carpetas
   `app`, `modelo` y `servicio`).
2. Hacer clic en la barra de direcciones del Explorador de archivos, escribir `cmd` y
   pulsar Enter. Se abre una terminal ya ubicada en `src`.

### Paso 4. Compilar y ejecutar
Escribir estos dos comandos, uno por uno, pulsando Enter después de cada uno:

    javac -d ..\out app\*.java modelo\*.java servicio\*.java
    java -cp ..\out app.Main

(En Linux o Mac, usar `/` en lugar de `\`.) El primero compila y el segundo inicia el
programa. Debe aparecer el menú «SISTEMA DE IMPRESIÓN 3D»; para usarlo, escribir el
número de la opción en la misma terminal y pulsar Enter.

### Alternativa: ejecutar desde un IDE
Abrir la carpeta del proyecto en VS Code (con la extensión Java), IntelliJ IDEA o
NetBeans y ejecutar la clase `app.Main`.

### Problemas frecuentes
- «javac no se reconoce»: el JDK no está instalado o hay que reiniciar la terminal.
- «Could not find or load main class»: la terminal no está en la carpeta `src`, no se
  compiló antes, o se escribió `java Main` en lugar de `java -cp ..\out app.Main`.
- Errores raros de `javac`: revisar que ninguna carpeta de la ruta tenga espacios al
  final del nombre.

## Funcionalidades (Entrega 2)
- Registrar pedidos y cotizaciones, eligiendo el material de cada placa (PLA, PETG o TPU).
- Resumen del día (pedidos atendidos y total vendido).
- Catálogo de materiales con buscador por parte del nombre.
- Agenda semanal de la impresora (matriz 5 x 3): consultar, reservar, liberar o poner en
  mantenimiento un turno.

## Reglas de cobro
- Energía: $2.000 por kW, con un consumo de 0,3 kW por hora de impresión.
- Filamento (si el usuario lo activa en el pedido): PLA $100 por gramo, PETG $150 por
  gramo y TPU $200 por gramo.
- Desgaste de máquina: $6.000 por placa.
- Mano de obra: $3.000 por hora de impresión.
- Recargo por uso: $5.000 por cada 10 placas completas del pedido.
- El total se redondea hacia arriba a la centena más cercana.

## Reglas de la agenda
- Solo se puede reservar un turno libre y para un pedido ya registrado.
- Solo se puede poner en mantenimiento un turno libre.
- Un turno reservado o en mantenimiento se puede liberar.

## Validaciones de entrada
- Cantidad de placas: número entero entre 1 y 100.
- Cobrar filamento y tipo de material: solo las opciones que muestra el menú.
- Tiempo de impresión: número entero entre 1 y 10000 minutos.
- Peso de la pieza: mayor que 0 y máximo 750 g por placa.
- Si el usuario escribe letras o un valor fuera de rango, el programa lo avisa y vuelve a
  preguntar. En los menús, una opción inválida muestra un aviso y vuelve al menú.
- Los decimales (peso) se escriben con el formato del sistema (coma o punto).

## Estructura
- `src/app`: `Main` (menú de consola).
- `src/modelo`: `Material` (abstracta), `MaterialPLA`, `MaterialPETG`, `MaterialTPU`,
  `Energia`, `Placas`, `Pedido`, `Turno`.
- `src/servicio`: `CrearPedido`, `ResumenDia`, `Catalogo`, `Agenda`.
- `docs/`: diagrama UML.
