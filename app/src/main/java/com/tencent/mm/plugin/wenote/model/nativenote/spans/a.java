package com.tencent.mm.plugin.wenote.model.nativenote.spans;

public final class a {
    public final q tVx;
    public int tVy;
    public int tVz;

    public a(q qVar, int i, int i2) {
        this.tVx = qVar;
        this.tVy = i;
        this.tVz = i2;
    }

    public final String toString() {
        return this.tVx.name() + " - " + this.tVy + "/" + this.tVz;
    }
}
