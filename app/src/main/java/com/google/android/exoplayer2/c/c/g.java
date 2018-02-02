package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.a;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import java.util.Collections;
import java.util.List;

public final class g implements h {
    private int alO;
    private final List<a> anf;
    private final k[] ang;
    private boolean anh;
    private int ani;
    private long anj;

    public g(List<a> list) {
        this.anf = list;
        this.ang = new k[list.size()];
    }

    public final void jx() {
        this.anh = false;
    }

    public final void a(f fVar, d dVar) {
        for (int i = 0; i < this.ang.length; i++) {
            a aVar = (a) this.anf.get(i);
            dVar.jF();
            k ck = fVar.ck(dVar.jG());
            ck.f(Format.a(dVar.jH(), "application/dvbsubs", Collections.singletonList(aVar.apf), aVar.ael));
            this.ang[i] = ck;
        }
    }

    public final void c(long j, boolean z) {
        if (z) {
            this.anh = true;
            this.anj = j;
            this.alO = 0;
            this.ani = 2;
        }
    }

    public final void jy() {
        if (this.anh) {
            for (k a : this.ang) {
                a.a(this.anj, 1, this.alO, 0, null);
            }
            this.anh = false;
        }
    }

    public final void b(j jVar) {
        int i = 0;
        if (!this.anh) {
            return;
        }
        if (this.ani == 2 && !c(jVar, 32)) {
            return;
        }
        if (this.ani != 1 || c(jVar, 0)) {
            int i2 = jVar.position;
            int lF = jVar.lF();
            k[] kVarArr = this.ang;
            int length = kVarArr.length;
            while (i < length) {
                k kVar = kVarArr[i];
                jVar.cR(i2);
                kVar.a(jVar, lF);
                i++;
            }
            this.alO += lF;
        }
    }

    private boolean c(j jVar, int i) {
        if (jVar.lF() == 0) {
            return false;
        }
        if (jVar.readUnsignedByte() != i) {
            this.anh = false;
        }
        this.ani--;
        return this.anh;
    }
}
