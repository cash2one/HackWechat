package com.eclipsesource.a;

import java.io.Writer;

class k$a extends i {
    private final char[] acb;
    private int acc;

    private k$a(Writer writer, char[] cArr) {
        super(writer);
        this.acb = cArr;
    }

    protected final void hD() {
        this.acc++;
        this.aca.write(91);
        hK();
    }

    protected final void hE() {
        this.acc--;
        hK();
        this.aca.write(93);
    }

    protected final void hF() {
        this.aca.write(44);
        if (!hK()) {
            this.aca.write(32);
        }
    }

    protected final void hG() {
        this.acc++;
        this.aca.write(123);
        hK();
    }

    protected final void hH() {
        this.acc--;
        hK();
        this.aca.write(125);
    }

    protected final void hI() {
        this.aca.write(58);
        this.aca.write(32);
    }

    protected final void hJ() {
        this.aca.write(44);
        if (!hK()) {
            this.aca.write(32);
        }
    }

    private boolean hK() {
        int i = 0;
        if (this.acb == null) {
            return false;
        }
        this.aca.write(10);
        while (i < this.acc) {
            this.aca.write(this.acb);
            i++;
        }
        return true;
    }
}
