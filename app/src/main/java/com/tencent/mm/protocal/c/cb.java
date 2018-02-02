package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cb extends a {
    public String hvC;
    public String hvu;
    public String hvv;
    public String ksU;
    public String ngs;
    public String vHm;
    public String vHn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hvC != null) {
                aVar.g(1, this.hvC);
            }
            if (this.hvu != null) {
                aVar.g(2, this.hvu);
            }
            if (this.hvv != null) {
                aVar.g(3, this.hvv);
            }
            if (this.ngs != null) {
                aVar.g(4, this.ngs);
            }
            if (this.ksU != null) {
                aVar.g(5, this.ksU);
            }
            if (this.vHm != null) {
                aVar.g(6, this.vHm);
            }
            if (this.vHn == null) {
                return 0;
            }
            aVar.g(7, this.vHn);
            return 0;
        } else if (i == 1) {
            if (this.hvC != null) {
                r0 = e.a.a.b.b.a.h(1, this.hvC) + 0;
            } else {
                r0 = 0;
            }
            if (this.hvu != null) {
                r0 += e.a.a.b.b.a.h(2, this.hvu);
            }
            if (this.hvv != null) {
                r0 += e.a.a.b.b.a.h(3, this.hvv);
            }
            if (this.ngs != null) {
                r0 += e.a.a.b.b.a.h(4, this.ngs);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksU);
            }
            if (this.vHm != null) {
                r0 += e.a.a.b.b.a.h(6, this.vHm);
            }
            if (this.vHn != null) {
                r0 += e.a.a.b.b.a.h(7, this.vHn);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cb cbVar = (cb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbVar.hvC = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cbVar.hvu = aVar3.Avy.readString();
                    return 0;
                case 3:
                    cbVar.hvv = aVar3.Avy.readString();
                    return 0;
                case 4:
                    cbVar.ngs = aVar3.Avy.readString();
                    return 0;
                case 5:
                    cbVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    cbVar.vHm = aVar3.Avy.readString();
                    return 0;
                case 7:
                    cbVar.vHn = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
