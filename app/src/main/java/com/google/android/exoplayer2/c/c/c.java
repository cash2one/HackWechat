package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class c implements d {
    public static final g aiT = new 1();
    private static final int amF = t.ak("ID3");
    private final long amG;
    private boolean amJ;
    private final d amQ;
    private final j amR;

    public c() {
        this(0);
    }

    public c(long j) {
        this.amG = j;
        this.amQ = new d();
        this.amR = new j(200);
    }

    public final void a(f fVar) {
        this.amQ.a(fVar, new u.d());
        fVar.ju();
        a aVar = new a(-9223372036854775807L);
    }

    public final int a(e eVar) {
        int read = eVar.read(this.amR.data, 0, 200);
        if (read == -1) {
            return -1;
        }
        this.amR.cR(0);
        this.amR.cU(read);
        if (!this.amJ) {
            this.amQ.aig = this.amG;
            this.amJ = true;
        }
        this.amQ.b(this.amR);
        return 0;
    }
}
