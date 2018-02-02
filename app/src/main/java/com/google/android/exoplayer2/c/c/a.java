package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class a implements d {
    public static final g aiT = new 1();
    private static final int amF = t.ak("ID3");
    private final long amG;
    private final b amH;
    private final j amI;
    private boolean amJ;

    public a() {
        this(0);
    }

    public a(long j) {
        this.amG = j;
        this.amH = new b();
        this.amI = new j(2786);
    }

    public final void a(f fVar) {
        this.amH.a(fVar, new u$d());
        fVar.ju();
        com.google.android.exoplayer2.c.j.a aVar = new com.google.android.exoplayer2.c.j.a(-9223372036854775807L);
    }

    public final int a(e eVar) {
        int read = eVar.read(this.amI.data, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.amI.cR(0);
        this.amI.cU(read);
        if (!this.amJ) {
            this.amH.aig = this.amG;
            this.amJ = true;
        }
        this.amH.b(this.amI);
        return 0;
    }
}
