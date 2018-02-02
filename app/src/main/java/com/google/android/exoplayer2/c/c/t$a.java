package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.c.t.b;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

class t$a implements p {
    private final i apa = new i(new byte[4]);
    final /* synthetic */ t apb;

    public t$a(t tVar) {
        this.apb = tVar;
    }

    public final void a(q qVar, f fVar, d dVar) {
    }

    public final void b(j jVar) {
        if (jVar.readUnsignedByte() == 0) {
            jVar.cV(7);
            int lF = jVar.lF() / 4;
            for (int i = 0; i < lF; i++) {
                jVar.c(this.apa, 4);
                int cT = this.apa.cT(16);
                this.apa.cS(3);
                if (cT == 0) {
                    this.apa.cS(13);
                } else {
                    cT = this.apa.cT(13);
                    t.a(this.apb).put(cT, new q(new b(this.apb, cT)));
                    t.b(this.apb);
                }
            }
            if (t.c(this.apb) != 2) {
                t.a(this.apb).remove(0);
            }
        }
    }
}
