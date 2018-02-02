package com.google.android.exoplayer2.c.c;

public final class u$d {
    private String amW;
    private final String api;
    private final int apj;
    private final int apk;
    private int apl;

    public u$d() {
        this(Integer.MIN_VALUE, 0, 1);
    }

    public u$d(int i, int i2, int i3) {
        this.api = i != Integer.MIN_VALUE ? i + "/" : "";
        this.apj = i2;
        this.apk = i3;
        this.apl = Integer.MIN_VALUE;
    }

    public final void jF() {
        this.apl = this.apl == Integer.MIN_VALUE ? this.apj : this.apl + this.apk;
        this.amW = this.api + this.apl;
    }

    public final int jG() {
        jI();
        return this.apl;
    }

    public final String jH() {
        jI();
        return this.amW;
    }

    private void jI() {
        if (this.apl == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }
}
