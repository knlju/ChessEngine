package engine.pretraga;

import engine.evaluacija.EvaluatorTable;
import engine.tabla.Tabla;
import engine.tabla.potez.Potez;
import engine.tabla.potez.PrelazPoteza;

public class MiniMax {

    private EvaluatorTable evaluator;
    private int c;

    public MiniMax() {
        this.evaluator = new EvaluatorTable();
        this.c = 0;
    }

    public Potez izracunaj(Tabla tabla, int dubina) {

        this.c = 0;
        long pocetnoVreme = System.currentTimeMillis();

        Potez najboljiPotez = null;

        int najvecaVrednost = Integer.MIN_VALUE;
        int najmanjaVrednost = Integer.MAX_VALUE;
        int trenutnaVrednost = 0;

        System.out.println("Razmislja dubinom:" + dubina);

        for (Potez potez :
                tabla.getTrenutniIgrac().getLegalniPotezi()) {
            PrelazPoteza prelazPoteza = tabla.getTrenutniIgrac().napraviPotez(potez);
            if (prelazPoteza.getStatusPoteza().isLegalan()) {

                trenutnaVrednost = tabla.getTrenutniIgrac().getBoja().isBeli() ?
                        min(prelazPoteza.getPrelaznaTabla(), dubina - 1) :
                        max(prelazPoteza.getPrelaznaTabla(), dubina - 1);

                if (tabla.getTrenutniIgrac().getBoja().isBeli() && trenutnaVrednost >= najvecaVrednost){
                    najvecaVrednost = trenutnaVrednost;
                    najboljiPotez = potez;
                } else if (!tabla.getTrenutniIgrac().getBoja().isBeli() && trenutnaVrednost <= najmanjaVrednost){
                    najmanjaVrednost = trenutnaVrednost;
                    najboljiPotez = potez;
                }
            }
        }


        System.out.println("Najbolji potez: " + najboljiPotez + ":" + trenutnaVrednost);
        System.out.println("Broj pregledanih node-a: " + c);
        System.out.println("vreme za izvrsenje:" + (System.currentTimeMillis() - pocetnoVreme));
        return najboljiPotez;
    }

    private int min(Tabla tabla, int dubina) {
        this.c++;

        if (dubina == 0|| tabla.getTrenutniIgrac().isUMatu() || tabla.getTrenutniIgrac().isUPatu()) return evaluator.vratiEvaluaciju(tabla);

        int min = Integer.MAX_VALUE;

        for (Potez potez :
                tabla.getTrenutniIgrac().getLegalniPotezi()) {
            PrelazPoteza prelaz = tabla.getTrenutniIgrac().napraviPotez(potez);
            if (prelaz.getStatusPoteza().isLegalan()) {
                int trenutnaVrednost = max(prelaz.getPrelaznaTabla(), dubina - 1);
                if (trenutnaVrednost <= min) {
                    min = trenutnaVrednost;
                }
            }
        }

        return min;
    }


    private int max(Tabla tabla, int dubina) {
        this.c++;

        if (dubina == 0|| tabla.getTrenutniIgrac().isUMatu() || tabla.getTrenutniIgrac().isUPatu()) return evaluator.vratiEvaluaciju(tabla);

        int max = Integer.MIN_VALUE;

        for (Potez potez :
                tabla.getTrenutniIgrac().getLegalniPotezi()) {
            PrelazPoteza prelaz = tabla.getTrenutniIgrac().napraviPotez(potez);
            if (prelaz.getStatusPoteza().isLegalan()) {
                int trenutnaVrednost = min(prelaz.getPrelaznaTabla(), dubina - 1);
                if (trenutnaVrednost >= max) {
                    max = trenutnaVrednost;
                }
            }
        }

        return max;
    }

}
