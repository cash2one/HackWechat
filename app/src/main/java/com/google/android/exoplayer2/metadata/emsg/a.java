package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.aif;
        j jVar = new j(byteBuffer.array(), byteBuffer.limit());
        String lK = jVar.lK();
        String lK2 = jVar.lK();
        long aK = jVar.aK();
        jVar.cV(4);
        return new Metadata(new Metadata$Entry[]{new EventMessage(lK, lK2, (jVar.aK() * 1000) / aK, jVar.aK(), Arrays.copyOfRange(r1, jVar.position, r0))});
    }
}
