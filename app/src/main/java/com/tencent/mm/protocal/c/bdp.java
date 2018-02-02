package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class bdp extends a {
    public int wJH;
    private boolean wJI;

    public final /* synthetic */ a aF(byte[] bArr) {
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a(aVar); a > 0; a = a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cJE();
            }
        }
        return cdR();
    }

    protected final /* synthetic */ a bkf() {
        return cdR();
    }

    public final bdp CW(int i) {
        this.wJH = i;
        this.wJI = true;
        return this;
    }

    public final String toString() {
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("uiVal = ").append(this.wJH).append("   ").toString())).append(")").toString();
    }

    private bdp cdR() {
        if (this.wJI) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  uiVal:" + this.wJI);
    }

    public final int bke() {
        return (e.a.a.a.fR(1, this.wJH) + 0) + 0;
    }

    public final byte[] toByteArray() {
        cdR();
        return super.toByteArray();
    }

    public final void a(e.a.a.c.a aVar) {
        aVar.fU(1, this.wJH);
    }

    public final boolean a(e.a.a.a.a aVar, a aVar2, int i) {
        bdp com_tencent_mm_protocal_c_bdp = (bdp) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_bdp.CW(aVar.Avy.ry());
                return true;
            default:
                return false;
        }
    }
}
