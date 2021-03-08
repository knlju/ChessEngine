package engine.tabla.figure;

import engine.tabla.Tabla;
import engine.tabla.TablaUtils;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.NapadackiPotez;
import engine.tabla.potez.Potez;
import engine.tabla.potez.TihiPotez;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lovac extends Figura {

    public static int[] pomeraj = {-9, 9, -11, 11};

    public Lovac(int koordinata, Boja boja) {
        super(koordinata, boja);
        this.tip = TipFigure.LOVAC;

    }

    @Override
    public Collection<Potez> izracunajLegalnePoteze(Tabla tabla) {
        List<Potez> legalniPotezi = new ArrayList<>();

        for (int kandidatPomeraj :
                pomeraj) {
            int kandidatKoordinata = this.koordinata + kandidatPomeraj;
            while (TablaUtils.validnostPolja[kandidatKoordinata]) {
                ValidnoPolje kandidatPolje = tabla.getPolje(kandidatKoordinata);
                if (kandidatPolje.isZauzeto()) {
                    Figura figuraNaDestinaciji = kandidatPolje.getFigura();
                    if (!figuraNaDestinaciji.getBoja().equals(this.boja)){
                        legalniPotezi.add(new NapadackiPotez(tabla,this, kandidatKoordinata,figuraNaDestinaciji));
                    }
                    break;
                } else {
                    legalniPotezi.add(new TihiPotez(tabla,this, kandidatKoordinata));
                }
                kandidatKoordinata += kandidatPomeraj;
            }
        }

        return Collections.unmodifiableCollection(legalniPotezi);
    }

    @Override
    public Lovac napraviFiguru(Potez potez) {
        return new Lovac(potez.getDestinaciju(),potez.getPomerenuFiguru().getBoja());
    }

    @Override
    public String toString() {
        return this.boja.equals(Boja.BELA) ? "B" : "b";
    }

}
