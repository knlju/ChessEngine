package engine.tabla.figure;

public enum Boja {
    BELA{
        @Override
        public boolean isBeli() {
            return true;
        }
    },
    CRNA {
        @Override
        public boolean isBeli() {
            return false;
        }
    };

    public abstract boolean isBeli();
}
