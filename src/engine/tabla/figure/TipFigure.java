package engine.tabla.figure;

public enum TipFigure {
    PION {
        @Override
        public boolean isKralj() {
            return false;
        }

        @Override
        public boolean isTop() {
            return false;
        }

        @Override
        public boolean isPion() {
            return true;
        }

        @Override
        public boolean isLovac() {
            return false;
        }

        @Override
        public int getVrednost() {
            return 100;
        }

        @Override
        public boolean isKraljica() {
            return false;
        }

        @Override
        public boolean isKonj() {
            return false;
        }
    },
    KONJ {
        @Override
        public boolean isKralj() {
            return false;
        }

        @Override
        public boolean isTop() {
            return false;
        }

        @Override
        public boolean isPion() {
            return false;
        }

        @Override
        public boolean isLovac() {
            return false;
        }

        @Override
        public int getVrednost() {
            return 320;
        }

        @Override
        public boolean isKraljica() {
            return false;
        }

        @Override
        public boolean isKonj() {
            return true;
        }
    },
    TOP {
        @Override
        public boolean isKralj() {
            return false;
        }

        @Override
        public boolean isTop() {
            return true;
        }

        @Override
        public boolean isPion() {
            return false;
        }

        @Override
        public boolean isLovac() {
            return false;
        }

        @Override
        public int getVrednost() {
            return 500;
        }

        @Override
        public boolean isKraljica() {
            return false;
        }

        @Override
        public boolean isKonj() {
            return false;
        }
    },
    LOVAC {
        @Override
        public boolean isKralj() {
            return false;
        }

        @Override
        public boolean isTop() {
            return false;
        }

        @Override
        public boolean isPion() {
            return false;
        }

        @Override
        public boolean isLovac() {
            return true;
        }

        @Override
        public int getVrednost() {
            return 350;
        }

        @Override
        public boolean isKraljica() {
            return false;
        }

        @Override
        public boolean isKonj() {
            return false;
        }
    },
    KRALJICA {
        @Override
        public boolean isKralj() {
            return false;
        }

        @Override
        public boolean isTop() {
            return false;
        }

        @Override
        public boolean isPion() {
            return false;
        }

        @Override
        public boolean isLovac() {
            return false;
        }

        @Override
        public int getVrednost() {
            return 900;
        }

        @Override
        public boolean isKraljica() {
            return true;
        }

        @Override
        public boolean isKonj() {
            return false;
        }
    },
    KRALJ {
        @Override
        public boolean isKralj() {
            return true;
        }

        @Override
        public boolean isTop() {
            return false;
        }

        @Override
        public boolean isPion() {
            return false;
        }

        @Override
        public boolean isLovac() {
            return false;
        }

        @Override
        public int getVrednost() {
            return 5000;
        }

        @Override
        public boolean isKraljica() {
            return false;
        }

        @Override
        public boolean isKonj() {
            return false;
        }
    };

    public abstract boolean isKralj();

    public abstract boolean isTop();

    public abstract boolean isPion();

    public abstract boolean isLovac();

    public abstract boolean isKraljica();

    public abstract boolean isKonj();

    public abstract int getVrednost();
}
