package engine.tabla.potez;

public enum StatusPoteza {
    NELEGALAN{
        @Override
        public boolean isNelegalan() {
            return true;
        }

        @Override
        public boolean isLegalan() {
            return false;
        }
    },
    LEGALAN {
        @Override
        public boolean isNelegalan() {
            return false;
        }

        @Override
        public boolean isLegalan() {
            return true;
        }
    };

    public abstract boolean isNelegalan();
    public abstract boolean isLegalan();
}
