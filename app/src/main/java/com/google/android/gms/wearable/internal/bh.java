package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.f;

public final class bh implements d {
    private int aMe;
    private f bfx;

    public bh(d dVar) {
        this.aMe = dVar.getType();
        this.bfx = (f) dVar.rp().oy();
    }

    public final int getType() {
        return this.aMe;
    }

    public final /* synthetic */ Object oy() {
        return this;
    }

    public final f rp() {
        return this.bfx;
    }

    public final String toString() {
        String str = this.aMe == 1 ? "changed" : this.aMe == 2 ? "deleted" : "unknown";
        return "DataEventEntity{ type=" + str + ", dataitem=" + this.bfx + " }";
    }
}
