package servicio;

import modelo.Turno;

public class Agenda {
    private static final String[] DIAS = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
    private static final String[] FRANJAS = {"Mañana", "Tarde", "Noche"};
    private static final String POSICION_INVALIDA = "Posición inválida: fila de 1 a 5 y columna de 1 a 3.";

    private final Turno[][] turnos;

    public Agenda() {
        turnos = new Turno[DIAS.length][FRANJAS.length];
        for (int i = 0; i < DIAS.length; i++) {
            for (int j = 0; j < FRANJAS.length; j++) {
                turnos[i][j] = new Turno();
            }
        }
    }

    private boolean posicionValida(int fila, int columna) {
        return fila >= 1 && fila <= DIAS.length && columna >= 1 && columna <= FRANJAS.length;
    }

    // Dibuja la matriz en consola
    public String mostrar() {
        String texto = "Columnas: 1 = Mañana, 2 = Tarde, 3 = Noche\n";
        for (int i = 0; i < DIAS.length; i++) {
            String dia = (i + 1) + ". " + DIAS[i];
            while (dia.length() < 15) {
                dia += " ";
            }
            texto += dia;
            for (int j = 0; j < FRANJAS.length; j++) {
                texto += turnos[i][j] + "  ";
            }
            texto += "\n";
        }
        return texto + "L = libre | R = reservado | M = mantenimiento";
    }

    public String consultar(int fila, int columna) {
        if (!posicionValida(fila, columna)) {
            return POSICION_INVALIDA;
        }
        Turno turno = turnos[fila - 1][columna - 1];
        String lugar = DIAS[fila - 1] + " - " + FRANJAS[columna - 1] + ": ";
        if (turno.getEstado() == Turno.LIBRE) {
            return lugar + "libre.";
        }
        if (turno.getEstado() == Turno.RESERVADO) {
            return lugar + "reservado para el pedido #" + turno.getNumeroPedido() + ".";
        }
        return lugar + "en mantenimiento.";
    }

    public String reservar(int fila, int columna, int numeroPedido) {
        if (!posicionValida(fila, columna)) {
            return POSICION_INVALIDA;
        }
        if (turnos[fila - 1][columna - 1].reservar(numeroPedido)) {
            return "Turno reservado para el pedido #" + numeroPedido + ".";
        }
        return "No se puede reservar: el turno no está libre.";
    }

    public String liberar(int fila, int columna) {
        if (!posicionValida(fila, columna)) {
            return POSICION_INVALIDA;
        }
        if (turnos[fila - 1][columna - 1].liberar()) {
            return "Turno liberado.";
        }
        return "El turno ya estaba libre.";
    }

    public String mantenimiento(int fila, int columna) {
        if (!posicionValida(fila, columna)) {
            return POSICION_INVALIDA;
        }
        if (turnos[fila - 1][columna - 1].ponerEnMantenimiento()) {
            return "Turno puesto en mantenimiento.";
        }
        return "No se puede: el turno está reservado o ya está en mantenimiento.";
    }
}