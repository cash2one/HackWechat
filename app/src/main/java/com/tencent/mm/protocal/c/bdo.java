package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bdo extends a {
    public String wJF;
    public boolean wJG;

    public final /* synthetic */ a aF(byte[] bArr) {
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cJE();
            }
        }
        return this;
    }

    protected final /* bridge */ /* synthetic */ a bkf() {
        return this;
    }

    public final bdo UA(String str) {
        this.wJF = str;
        this.wJG = true;
        return this;
    }

    public final String toString() {
        return this.wJF;
    }

    public final int bke() {
        int i = 0;
        if (this.wJG) {
            i = e.a.a.b.b.a.h(1, this.wJF) + 0;
        }
        return i + 0;
    }

    public final byte[] toByteArray() {
        return super.toByteArray();
    }

    public final void a(e.a.a.c.a aVar) {
        if (this.wJG) {
            aVar.g(1, this.wJF);
        }
    }

    public final boolean a(e.a.a.a.a aVar, a aVar2, int i) {
        bdo com_tencent_mm_protocal_c_bdo = (bdo) aVar2;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_bdo.UA(aVar.Avy.readString());
                return true;
            default:
                return false;
        }
    }
}
