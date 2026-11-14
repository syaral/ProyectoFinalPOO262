package modelo;

public class Turno {
    public static final char LIBRE = 'L';
    public static final char RESERVADO = 'R';
    public static final char MANTENIMIENTO = 'M';

    private char estado;
    private int numeroPedido;

    public Turno() {
        this.estado = LIBRE;
        this.numeroPedido = 0;
    }

    public char getEstado() { return estado; }
    public int getNumeroPedido() { return numeroPedido; }

    // Solo se puede reservar un turno libre
    public boolean reservar(int numeroPedido) {
        if (estado != LIBRE) {
            return false;
        }
        estado = RESERVADO;
        this.numeroPedido = numeroPedido;
        return true;
    }

    // Libera un turno reservado o termina un mantenimiento
    public boolean liberar() {
        if (estado == LIBRE) {
            return false;
        }
        estado = LIBRE;
        numeroPedido = 0;
        return true;
    }

    // Solo se puede poner en mantenimiento un turno libre
    public boolean ponerEnMantenimiento() {
        if (estado != LIBRE) {
            return false;
        }
        estado = MANTENIMIENTO;
        return true;
    }

    @Override
    public String toString() {
        return "[ " + estado + " ]";
    }
}