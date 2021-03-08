package engine.tabla.potez;

import engine.tabla.Tabla;

public class PrelazPoteza {

    private Tabla prelaznaTabla;
    private Potez potez;
    private StatusPoteza statusPoteza;

    public PrelazPoteza(Tabla prelaznaTabla, Potez potez) {
        this.prelaznaTabla = prelaznaTabla;
        this.potez = potez;
        this.statusPoteza = StatusPoteza.LEGALAN;
    }

    public PrelazPoteza(Tabla trenutnaPozicija, Potez potez, StatusPoteza statusPoteza) {
        this.prelaznaTabla = trenutnaPozicija;
        this.potez = potez;
        this.statusPoteza = statusPoteza;
    }

    public StatusPoteza getStatusPoteza() {
        return statusPoteza;
    }

    public Tabla getPrelaznaTabla() {
        return prelaznaTabla;
    }

    public Potez getPotez() {
        return potez;
    }
}
