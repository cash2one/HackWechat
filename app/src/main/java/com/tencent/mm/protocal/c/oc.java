package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class oc extends a {
    public String fFm;
    public String path;
    public int qhM;
    public long vXb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.vXb);
            aVar.fU(2, this.qhM);
            if (this.fFm != null) {
                aVar.g(3, this.fFm);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.R(1, this.vXb) + 0) + e.a.a.a.fR(2, this.qhM);
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(3, this.fFm);
            }
            if (this.path != null) {
                return r0 + e.a.a.b.b.a.h(4, this.path);
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
            oc ocVar = (oc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ocVar.vXb = aVar3.Avy.rz();
                    return 0;
                case 2:
                    ocVar.qhM = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ocVar.fFm = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ocVar.path = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
