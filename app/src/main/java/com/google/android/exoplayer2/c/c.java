package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.j;
import java.io.EOFException;

public final class c implements k {
    public final void f(Format format) {
    }

    public final int a(e eVar, int i, boolean z) {
        int ce = eVar.ce(i);
        if (ce != -1) {
            return ce;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void a(j jVar, int i) {
        jVar.cV(i);
    }

    public final void a(long j, int i, int i2, int i3, k$a com_google_android_exoplayer2_c_k_a) {
    }
}
