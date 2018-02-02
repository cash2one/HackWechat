package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bdn extends a {
    public int wJB;
    private boolean wJC;
    public b wJD;
    public boolean wJE;

    public final /* synthetic */ a aF(byte[] bArr) {
        return bk(bArr);
    }

    protected final /* synthetic */ a bkf() {
        return cdQ();
    }

    private bdn CV(int i) {
        this.wJB = i;
        this.wJC = true;
        return this;
    }

    public final bdn bj(byte[] bArr) {
        b bc = b.bc(bArr);
        b(bc);
        CV(bc.oz.length);
        return this;
    }

    public final bdn N(byte[] bArr, int i) {
        b s = b.s(bArr, 0, i);
        b(s);
        CV(s.oz.length);
        return this;
    }

    public final bdn b(b bVar) {
        if (bVar == null) {
            bj(null);
        }
        this.wJD = bVar;
        this.wJE = true;
        CV(this.wJD.oz.length);
        return this;
    }

    public final String toString() {
        Object stringBuilder = new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("iLen = ").append(this.wJB).append("   ").toString();
        if (this.wJE) {
            stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("Buffer = ").append(this.wJD).append("   ").toString();
        }
        return new StringBuilder(String.valueOf(stringBuilder)).append(")").toString();
    }

    private bdn cdQ() {
        if (this.wJC) {
            return this;
        }
        throw new e.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.wJC);
    }

    public final int bke() {
        int fR = e.a.a.a.fR(1, this.wJB) + 0;
        if (this.wJE) {
            fR += e.a.a.a.a(2, this.wJD);
        }
        return fR + 0;
    }

    public final byte[] toByteArray() {
        cdQ();
        return super.toByteArray();
    }

    public final void a(e.a.a.c.a aVar) {
        aVar.fU(1, this.wJB);
        if (this.wJE) {
            aVar.b(2, this.wJD);
        }
    }

    public final boolean a(e.a.a.a.a aVar, a aVar2, int i) {
        bdn com_tencent_mm_protocal_c_bdn = (bdn) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_bdn.CV(aVar.Avy.ry());
                return true;
            case 2:
                com_tencent_mm_protocal_c_bdn.b(aVar.cJD());
                return true;
            default:
                return false;
        }
    }

    public final bdn bk(byte[] bArr) {
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cJE();
            }
        }
        return cdQ();
    }
}
