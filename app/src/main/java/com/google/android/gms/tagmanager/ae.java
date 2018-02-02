package com.google.android.gms.tagmanager;

final class ae extends ad {
    private static ae bcA;
    private static final Object bcr = new Object();
    private j bcs;
    private volatile i bct;
    private int bcu = 1800000;
    private boolean bcv = true;
    private boolean bcw = false;
    private boolean bcx = true;
    private k bcy = new 1(this);
    private boolean bcz = false;
    private boolean connected = true;

    private ae() {
    }

    public static ae rb() {
        if (bcA == null) {
            bcA = new ae();
        }
        return bcA;
    }

    public final synchronized void ra() {
        if (this.bcw) {
            i iVar = this.bct;
            2 2 = new 2(this);
        } else {
            m.qG();
            this.bcv = true;
        }
    }
}
