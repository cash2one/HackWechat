package com.google.android.exoplayer2.f.b;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.b.b.h;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.j;
import java.util.List;

public final class a extends b {
    private final b axz;

    protected final /* synthetic */ d a(byte[] bArr, int i, boolean z) {
        if (z) {
            h hVar = this.axz.axI;
            hVar.axU.clear();
            hVar.aym.clear();
            hVar.ayn.clear();
            hVar.ayo.clear();
            hVar.ayp.clear();
            hVar.ayq = null;
            hVar.ayr = null;
        }
        return new c(this.axz.e(bArr, i));
    }

    public a(List<byte[]> list) {
        super("DvbDecoder");
        j jVar = new j((byte[]) list.get(0));
        this.axz = new b(jVar.readUnsignedShort(), jVar.readUnsignedShort());
    }
}
