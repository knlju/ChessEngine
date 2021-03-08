package engine.tabla.potez;

public class NullPotez extends Potez {

    public static NullPotez instance = new NullPotez();

    private NullPotez() {
        super(null, null, -1);
    }

    @Override
    public boolean isNapadackiPotez() {
        return false;
    }

    public static NullPotez getInstance(){
        return instance;
    }

    @Override
    public boolean isNullPotez() {
        return true;
    }
}
