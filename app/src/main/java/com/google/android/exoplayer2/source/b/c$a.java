package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a.c;
import java.util.Arrays;

final class c$a extends c {
    public final String atl;
    byte[] atm;

    public c$a(f fVar, i iVar, Format format, int i, Object obj, byte[] bArr, String str) {
        super(fVar, iVar, format, i, obj, bArr);
        this.atl = str;
    }

    protected final void d(byte[] bArr, int i) {
        this.atm = Arrays.copyOf(bArr, i);
    }
}
