package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.source.g.a;
import java.io.EOFException;

public final class h implements k {
    public final j aiY = new j(32);
    public long ano;
    public final b asj;
    public final int ask;
    public final g asl = new g();
    public final a asm = new a();
    public a asn = new a(0, this.ask);
    public a aso = this.asn;
    public a asp = this.asn;
    public Format asq;
    private boolean asr;
    private Format ass;
    private long ast;
    public boolean asu;
    public b asv;

    public h(b bVar) {
        this.asj = bVar;
        this.ask = bVar.ln();
    }

    public final void rewind() {
        this.asl.rewind();
        this.aso = this.asn;
    }

    public final void km() {
        H(this.asl.kl());
    }

    public final boolean d(long j, boolean z) {
        return this.asl.a(j, true, z);
    }

    public final void a(long j, byte[] bArr, int i) {
        G(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.aso.alc - j));
            System.arraycopy(this.aso.asy.data, this.aso.I(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == this.aso.alc) {
                this.aso = this.aso.asz;
            }
        }
    }

    public final void G(long j) {
        while (j >= this.aso.alc) {
            this.aso = this.aso.asz;
        }
    }

    public final void H(long j) {
        if (j != -1) {
            while (j >= this.asn.alc) {
                this.asj.a(this.asn.asy);
                this.asn = this.asn.kn();
            }
            if (this.aso.asw < this.asn.asw) {
                this.aso = this.asn;
            }
        }
    }

    public final void f(Format format) {
        long j = this.ast;
        Format q = format == null ? null : (j == 0 || format.aej == Long.MAX_VALUE) ? format : format.q(j + format.aej);
        boolean i = this.asl.i(q);
        this.ass = format;
        this.asr = false;
        if (this.asv != null && i) {
            this.asv.ko();
        }
    }

    public final int a(e eVar, int i, boolean z) {
        int read = eVar.read(this.asp.asy.data, this.asp.I(this.ano), cE(i));
        if (read != -1) {
            cF(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void a(j jVar, int i) {
        while (i > 0) {
            int cE = cE(i);
            jVar.readBytes(this.asp.asy.data, this.asp.I(this.ano), cE);
            i -= cE;
            cF(cE);
        }
    }

    public final void a(long j, int i, int i2, int i3, k.a aVar) {
        if (this.asr) {
            f(this.ass);
        }
        if (this.asu) {
            if ((i & 1) != 0 && this.asl.F(j)) {
                this.asu = false;
            } else {
                return;
            }
        }
        this.asl.a(j + this.ast, i, (this.ano - ((long) i2)) - ((long) i3), i2, aVar);
    }

    private int cE(int i) {
        if (!this.asp.asx) {
            a aVar = this.asp;
            com.google.android.exoplayer2.h.a ll = this.asj.ll();
            a aVar2 = new a(this.asp.alc, this.ask);
            aVar.asy = ll;
            aVar.asz = aVar2;
            aVar.asx = true;
        }
        return Math.min(i, (int) (this.asp.alc - this.ano));
    }

    private void cF(int i) {
        this.ano += (long) i;
        if (this.ano == this.asp.alc) {
            this.asp = this.asp.asz;
        }
    }
}
