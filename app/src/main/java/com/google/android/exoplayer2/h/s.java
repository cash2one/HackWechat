package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.i.t;
import java.io.Closeable;

public final class s<T> implements c {
    private final a<? extends T> aBS;
    private volatile boolean aBT;
    public volatile long aBU;
    private final f aiB;
    public final i asH;
    public volatile T result;
    public final int type = 4;

    public s(f fVar, Uri uri, a<? extends T> aVar) {
        this.aiB = fVar;
        this.asH = new i(uri);
        this.aBS = aVar;
    }

    public final void kq() {
        this.aBT = true;
    }

    public final boolean kr() {
        return this.aBT;
    }

    public final void ks() {
        Closeable hVar = new h(this.aiB, this.asH);
        try {
            hVar.lp();
            this.result = this.aBS.b(this.aiB.getUri(), hVar);
        } finally {
            this.aBU = hVar.aAI;
            t.b(hVar);
        }
    }
}
