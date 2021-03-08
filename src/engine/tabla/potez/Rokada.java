package engine.tabla.potez;

import engine.tabla.Tabla;
import engine.tabla.TablaBuilder;
import engine.tabla.figure.Figura;
import engine.tabla.figure.Kralj;
import engine.tabla.figure.Top;

public abstract class Rokada extends Potez{
    protected Top top;
    protected int topPocetnaKoordinata;
    protected int topZavrsnaKoordinata;

    public Rokada(Tabla pozicija, Figura pomerenaFigura, int koordinataDestinacije, Top top, int topPocetnaKoordinata, int topZavrsnaKoordinata) {
        super(pozicija, pomerenaFigura, koordinataDestinacije);
        this.top = top;
        this.topPocetnaKoordinata = topPocetnaKoordinata;
        this.topZavrsnaKoordinata = topZavrsnaKoordinata;
    }

    public Top getTop() {
        return top;
    }

    public int getTopPocetnaKoordinata() {
        return topPocetnaKoordinata;
    }

    public int getTopZavrsnaKoordinata() {
        return topZavrsnaKoordinata;
    }

    @Override
    public  boolean isRokada(){
        return true;
    }

}
