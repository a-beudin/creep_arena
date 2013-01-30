package fr.creeparena.util;

public enum Direction {
    NORD, SUD, EST, OUEST, NORD_OUEST, NORD_EST, SUD_OUEST, SUD_EST;

    public int newX(int x) {
        switch (this) {
            case EST: x++; break;
            case OUEST: x--; break;
            case NORD_OUEST: x--; break;
            case NORD_EST: x++; break;
            case SUD_OUEST: x--; break;
            case SUD_EST: x++; break;
        }
        return x;
    }
    
    public int newY(int y) {
        switch (this) {
            case SUD: y++; break;
            case NORD: y--; break;
            case NORD_OUEST: y--; break;
            case NORD_EST: y--; break;
            case SUD_OUEST: y++; break;
            case SUD_EST: y++; break;
        }
        return y;
    }

}

