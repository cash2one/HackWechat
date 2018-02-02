package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class s implements p {
    private q alA;
    private k alW;
    private boolean aoM;

    public final void a(q qVar, f fVar, u$d com_google_android_exoplayer2_c_c_u_d) {
        this.alA = qVar;
        com_google_android_exoplayer2_c_c_u_d.jF();
        this.alW = fVar.ck(com_google_android_exoplayer2_c_c_u_d.jG());
        this.alW.f(Format.g(com_google_android_exoplayer2_c_c_u_d.jH(), "application/x-scte35"));
    }

    public final void b(j jVar) {
        long j = -9223372036854775807L;
        if (!this.aoM) {
            if (this.alA.lQ() != -9223372036854775807L) {
                this.alW.f(Format.b("application/x-scte35", this.alA.lQ()));
                this.aoM = true;
            } else {
                return;
            }
        }
        int lF = jVar.lF();
        this.alW.a(jVar, lF);
        k kVar = this.alW;
        q qVar = this.alA;
        if (qVar.aCH != -9223372036854775807L) {
            j = qVar.aCH;
        } else if (qVar.amG != Long.MAX_VALUE) {
            j = qVar.amG;
        }
        kVar.a(j, 1, lF, 0, null);
    }
}
