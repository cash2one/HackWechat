package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.f.a.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import java.util.List;

final class r {
    private final List<Format> and;
    private final k[] ang;

    public r(List<Format> list) {
        this.and = list;
        this.ang = new k[list.size()];
    }

    public final void a(f fVar, d dVar) {
        for (int i = 0; i < this.ang.length; i++) {
            boolean z;
            dVar.jF();
            k ck = fVar.ck(dVar.jG());
            Format format = (Format) this.and.get(i);
            String str = format.adV;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z = true;
            } else {
                z = false;
            }
            a.b(z, "Invalid closed caption mime type provided: " + str);
            ck.f(Format.a(format.id != null ? format.id : dVar.jH(), str, format.aek, format.ael, format.aem));
            this.ang[i] = ck;
        }
    }

    public final void a(long j, j jVar) {
        g.a(j, jVar, this.ang);
    }
}
