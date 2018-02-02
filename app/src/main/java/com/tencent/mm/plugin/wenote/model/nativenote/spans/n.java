package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;

public final class n extends e {
    final boolean tVG;
    public final boolean tVH;

    public n(int i, int i2, boolean z, boolean z2) {
        super(i, i2);
        this.tVG = z;
        this.tVH = z2;
    }

    public final boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar.isEmpty()) {
            boolean z;
            if (eVar.Ww < this.Ww || eVar.wq >= this.wq) {
                z = false;
            } else {
                z = true;
            }
            boolean z2;
            if (eVar.Ww < this.Ww || eVar.wq > this.wq) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || (r3 && this.tVH)) {
                return true;
            }
            return false;
        } else if (Math.max(this.Ww, eVar.Ww) < Math.min(this.wq, eVar.wq)) {
            return true;
        } else {
            return false;
        }
    }

    public final int bXz() {
        return Math.abs(this.wq - this.Ww);
    }
}
