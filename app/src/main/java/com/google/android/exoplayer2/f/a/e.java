package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.i;

public final class e extends i {
    private final d axy;

    public e(d dVar) {
        this.axy = dVar;
    }

    public final void release() {
        d dVar = this.axy;
        clear();
        dVar.axv.add(this);
    }
}
