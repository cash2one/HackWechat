package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.d;
import com.google.android.exoplayer2.source.b.a.e.e;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.f.b;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.w;
import java.util.List;

public final class h implements e, f {
    private final d atM;
    private final int atN;
    private final a atO;
    private final Uri atV;
    private final s.a<c> atW;
    private f.a atX;
    private com.google.android.exoplayer2.source.b.a.e ata;

    static {
        j.K("goog.exo.hls");
    }

    public h(Uri uri, com.google.android.exoplayer2.h.f.a aVar, Handler handler, com.google.android.exoplayer2.source.a aVar2) {
        this(uri, aVar, handler, aVar2, (byte) 0);
    }

    private h(Uri uri, com.google.android.exoplayer2.h.f.a aVar, Handler handler, com.google.android.exoplayer2.source.a aVar2, byte b) {
        this(uri, new b(aVar), 3, handler, aVar2);
    }

    private h(Uri uri, d dVar, int i, Handler handler, com.google.android.exoplayer2.source.a aVar) {
        this(uri, dVar, 3, handler, aVar, new d());
    }

    private h(Uri uri, d dVar, int i, Handler handler, com.google.android.exoplayer2.source.a aVar, s.a<c> aVar2) {
        this.atV = uri;
        this.atM = dVar;
        this.atN = i;
        this.atW = aVar2;
        this.atO = new a(handler, aVar);
    }

    public final void a(f.a aVar) {
        com.google.android.exoplayer2.i.a.an(this.ata == null);
        this.ata = new com.google.android.exoplayer2.source.b.a.e(this.atV, this.atM, this.atO, this.atN, this, this.atW);
        this.atX = aVar;
        r.a aVar2 = this.ata;
        aVar2.avE.a(new s(aVar2.atM.kt(), aVar2.avy, aVar2.atW), aVar2, aVar2.avz);
    }

    public final void kd() {
        com.google.android.exoplayer2.source.b.a.e eVar = this.ata;
        eVar.avE.kc();
        if (eVar.avF != null) {
            eVar.c(eVar.avF);
        }
    }

    public final com.google.android.exoplayer2.source.e a(b bVar, com.google.android.exoplayer2.h.b bVar2) {
        com.google.android.exoplayer2.i.a.am(bVar.arS == 0);
        return new g(this.ata, this.atM, this.atN, this.atO, bVar2);
    }

    public final void b(com.google.android.exoplayer2.source.e eVar) {
        g gVar = (g) eVar;
        gVar.ata.avD.remove(gVar);
        gVar.atQ.removeCallbacksAndMessages(null);
        for (j jVar : gVar.atS) {
            boolean a = jVar.aud.a(jVar);
            if (jVar.adD && !a) {
                for (com.google.android.exoplayer2.source.h km : jVar.auh) {
                    km.km();
                }
            }
            jVar.handler.removeCallbacksAndMessages(null);
            jVar.released = true;
        }
    }

    public final void ke() {
        if (this.ata != null) {
            com.google.android.exoplayer2.source.b.a.e eVar = this.ata;
            eVar.avE.a(null);
            for (com.google.android.exoplayer2.source.b.a.e.a aVar : eVar.avA.values()) {
                aVar.avJ.a(null);
            }
            eVar.avB.removeCallbacksAndMessages(null);
            eVar.avA.clear();
            this.ata = null;
        }
        this.atX = null;
    }

    public final void a(com.google.android.exoplayer2.source.b.a.b bVar) {
        w kVar;
        long j = bVar.auN ? 0 : -9223372036854775807L;
        long j2 = bVar.auN ? com.google.android.exoplayer2.b.j(bVar.asL) : -9223372036854775807L;
        long j3 = bVar.auG;
        if (this.ata.avH) {
            boolean z;
            long j4 = bVar.auM ? bVar.aes + bVar.asL : -9223372036854775807L;
            List list = bVar.auP;
            if (j3 == -9223372036854775807L) {
                long j5;
                if (list.isEmpty()) {
                    j5 = 0;
                } else {
                    j5 = ((com.google.android.exoplayer2.source.b.a.b.a) list.get(Math.max(0, list.size() - 3))).auR;
                }
                j3 = j5;
            }
            long j6 = bVar.aes;
            long j7 = bVar.asL;
            if (bVar.auM) {
                z = false;
            } else {
                z = true;
            }
            kVar = new k(j, j2, j4, j6, j7, j3, z);
        } else {
            if (j3 == -9223372036854775807L) {
                j3 = 0;
            }
            kVar = new k(j, j2, bVar.asL + bVar.aes, bVar.aes, bVar.asL, j3, false);
        }
        this.atX.a(kVar, new e(this.ata.atr, bVar));
    }
}
