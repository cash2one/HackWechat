package com.tencent.mm.kernel.c;

public final class d<T extends a> implements b, c<T> {
    private T gSP;

    public d(T t) {
        this.gSP = t;
    }

    public final T DV() {
        return this.gSP;
    }

    public final void DT() {
        if (this.gSP instanceof b) {
            ((b) this.gSP).DT();
        }
    }

    public final void DU() {
        if (this.gSP instanceof b) {
            ((b) this.gSP).DU();
        }
    }
}
