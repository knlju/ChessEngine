package engine.pretraga;

import engine.evaluacija.EvaluatorTable;
import engine.tabla.Igrac;
import engine.tabla.Tabla;
import engine.tabla.TablaUtils;
import engine.tabla.potez.NullPotez;
import engine.tabla.potez.Potez;
import engine.tabla.potez.PrelazPoteza;

public class AlphaBetaMax {

    private final static int QUIESCENCE_BOUND = 10_000;

    private EvaluatorTable evaluator;
    private int quiescenceCount;
    private int c;

    public AlphaBetaMax() {
        this.evaluator = new EvaluatorTable();
        this.quiescenceCount = 0;
        this.c = 0;
    }

    public Potez izracunaj(Tabla pozicija, int dubinaPretrage) {

        c=0;
        final long pocetnoVreme = System.currentTimeMillis();
        final Igrac trenutniIgrac = pozicija.getTrenutniIgrac();
        Potez najboljiPotez = NullPotez.getInstance();
        int najvecaVidjenaVrednost = Integer.MIN_VALUE;
        int najmanjaVidjenaVrednost = Integer.MAX_VALUE;
        int trenutnaVrednost = 0;
        System.out.println("Razmisljam dubinom: " + dubinaPretrage);
        for (final Potez potez : pozicija.getTrenutniIgrac().getLegalniPotezi()) {

            final PrelazPoteza prelazPoteza = pozicija.getTrenutniIgrac().napraviPotez(potez);
            this.quiescenceCount = 0;
            if (prelazPoteza.getStatusPoteza().isLegalan()) {
                trenutnaVrednost = trenutniIgrac.getBoja().isBeli() ?
                        min(prelazPoteza.getPrelaznaTabla(), dubinaPretrage - 1, najvecaVidjenaVrednost, najmanjaVidjenaVrednost) :
                        max(prelazPoteza.getPrelaznaTabla(), dubinaPretrage - 1, najvecaVidjenaVrednost, najmanjaVidjenaVrednost);
                if (trenutniIgrac.getBoja().isBeli() && trenutnaVrednost > najvecaVidjenaVrednost) {
                    najvecaVidjenaVrednost = trenutnaVrednost;
                    najboljiPotez = potez;
                    if (prelazPoteza.getPrelaznaTabla().getCrniIgrac().isUMatu()) {
                        break;
                    }
                } else if (!trenutniIgrac.getBoja().isBeli() && trenutnaVrednost < najmanjaVidjenaVrednost) {
                    najmanjaVidjenaVrednost = trenutnaVrednost;
                    najboljiPotez = potez;
                    if (prelazPoteza.getPrelaznaTabla().getBeliIgrac().isUMatu()) {
                        break;
                    }
                }
            }
        }
        boolean isMat = najboljiPotez.izvrsi().getTrenutniIgrac().isUMatu();
        boolean isSah = najboljiPotez.izvrsi().getTrenutniIgrac().isUSahu();

        String dodatak = isMat ? "++" : (isSah ? "+" : "");

        System.out.println("Najbolji potez: " + najboljiPotez + dodatak + ":" + trenutnaVrednost);
        System.out.println("Broj pregledanih node-a: " + c);
        System.out.println("vreme za izvrsenje:" + (System.currentTimeMillis() - pocetnoVreme));
        return najboljiPotez;
    }


    private int max(Tabla pozicija, int dubina, int alpha, int beta) {
        this.c++;
        if (dubina == 0 || pozicija.getTrenutniIgrac().isUMatu() || pozicija.getTrenutniIgrac().isUPatu()) {
            return this.evaluator.vratiEvaluaciju(pozicija);
        }
        int najvecaVidjenaVrednost = alpha;
        for (final Potez potez : pozicija.getTrenutniIgrac().getLegalniPotezi()) {
            final PrelazPoteza prelazPoteza = pozicija.getTrenutniIgrac().napraviPotez(potez);
            if (prelazPoteza.getStatusPoteza().isLegalan()) {
                Tabla prelaznaTabla = prelazPoteza.getPrelaznaTabla();
                najvecaVidjenaVrednost = Math.max(najvecaVidjenaVrednost, min(prelaznaTabla,
                        izracunajQuiesenceDubinu(prelaznaTabla, dubina), najvecaVidjenaVrednost, beta));
                if (najvecaVidjenaVrednost >= beta) {
                    return beta;
                }
            }
        }
        return najvecaVidjenaVrednost;
    }

    private int min(Tabla pozicija, int dubina, int alpha, int beta) {
        this.c++;
        if (dubina == 0 || pozicija.getTrenutniIgrac().isUMatu() || pozicija.getTrenutniIgrac().isUPatu()) {
            return this.evaluator.vratiEvaluaciju(pozicija);
        }
        int najmanjaVidjenaVrednost = beta;
        for (final Potez potez : pozicija.getTrenutniIgrac().getLegalniPotezi()) {
            final PrelazPoteza prelazPoteza = pozicija.getTrenutniIgrac().napraviPotez(potez);
            if (prelazPoteza.getStatusPoteza().isLegalan()) {
                Tabla prelaznaTabla = prelazPoteza.getPrelaznaTabla();
                najmanjaVidjenaVrednost = Math.min(najmanjaVidjenaVrednost, max(prelaznaTabla,
                        izracunajQuiesenceDubinu(prelaznaTabla, dubina), alpha, najmanjaVidjenaVrednost));
                if (najmanjaVidjenaVrednost <= alpha) {
                    return alpha;
                }
            }
        }
        return najmanjaVidjenaVrednost;
    }

    private int izracunajQuiesenceDubinu(Tabla prelaznaTabla, int dubina) {
        if (dubina == 1 && this.quiescenceCount < QUIESCENCE_BOUND) {
            int meraAktivnosti = 0;
            if (prelaznaTabla.getTrenutniIgrac().isUSahu()) {
                meraAktivnosti += 1;
            }
            for (Potez potez : TablaUtils.poslednjihNPoteza(prelaznaTabla, 2)) {
                if (potez.isNapadackiPotez()) {
                    meraAktivnosti += 1;
                }
            }
            if (meraAktivnosti >= 1) {
                this.quiescenceCount++;
                return 1;
            }
        }
        return dubina - 1;
    }

}
