package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.t;

public final class h {
    public final m aAw;
    public final f aAx;
    public final Object aAy;
    public final t[] aAz;

    public h(m mVar, f fVar, Object obj, t[] tVarArr) {
        this.aAw = mVar;
        this.aAx = fVar;
        this.aAy = obj;
        this.aAz = tVarArr;
    }

    public final boolean a(h hVar, int i) {
        if (hVar != null && com.google.android.exoplayer2.i.t.h(this.aAx.aAu[i], hVar.aAx.aAu[i]) && com.google.android.exoplayer2.i.t.h(this.aAz[i], hVar.aAz[i])) {
            return true;
        }
        return false;
    }
}
