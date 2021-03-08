package engine.tabla.figure;

import engine.tabla.Tabla;
import engine.tabla.TablaUtils;
import engine.tabla.polje.ValidnoPolje;
import engine.tabla.potez.NapadackiPotez;
import engine.tabla.potez.Potez;
import engine.tabla.potez.Rokada;
import engine.tabla.potez.TihiPotez;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Top extends Figura {

    private boolean prviPotez;


    public static int[] pomeraj = {-1, 1, -10, 10};

    public Top(int koordinata, Boja boja) {
        super(koordinata, boja);
        this.tip = TipFigure.TOP;
        this.prviPotez = true;
    }

    public Top(int koordinata, Boja boja, boolean prviPotez) {
        super(koordinata,boja);
        this.tip= TipFigure.TOP;
        this.prviPotez =prviPotez;
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
                        legalniPotezi.add(new NapadackiPotez(tabla, this, kandidatKoordinata,figuraNaDestinaciji));
                    }
                    break;
                } else {
                    legalniPotezi.add(new TihiPotez(tabla, this, kandidatKoordinata));
                }
                kandidatKoordinata += kandidatPomeraj;
            }
        }

        return Collections.unmodifiableCollection(legalniPotezi);
    }

    private boolean prviPotez() {
        return prviPotez;
    }

    @Override
    public Top napraviFiguru(Potez potez) {
        Top top = new Top(potez.getDestinaciju(), potez.getPomerenuFiguru().getBoja());
        top.setPrviPotez(prviPotez);
        return top;
    }

    public Top napraviFiguru(Rokada rokada){
        return new Top(rokada.getTopZavrsnaKoordinata(),rokada.getPomerenuFiguru().getBoja(),false);
    }

    @Override
    public String toString() {
        return this.boja.equals(Boja.BELA) ? "R" : "r";
    }

    public boolean isPrviPotez() {
        return prviPotez;
    }

    public void setPrviPotez(boolean prviPotez) {
        this.prviPotez = prviPotez;
    }
}
