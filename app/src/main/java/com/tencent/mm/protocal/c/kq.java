package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class kq extends a {
    public int ktm;
    public int vGO;
    public String vSu;
    public long vSv;
    public int vSw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSu != null) {
                aVar.g(1, this.vSu);
            }
            aVar.S(2, this.vSv);
            aVar.fU(3, this.vSw);
            aVar.fU(4, this.vGO);
            aVar.fU(5, this.ktm);
            return 0;
        } else if (i == 1) {
            if (this.vSu != null) {
                r0 = e.a.a.b.b.a.h(1, this.vSu) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.R(2, this.vSv)) + e.a.a.a.fR(3, this.vSw)) + e.a.a.a.fR(4, this.vGO)) + e.a.a.a.fR(5, this.ktm);
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
            kq kqVar = (kq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kqVar.vSu = aVar3.Avy.readString();
                    return 0;
                case 2:
                    kqVar.vSv = aVar3.Avy.rz();
                    return 0;
                case 3:
                    kqVar.vSw = aVar3.Avy.ry();
                    return 0;
                case 4:
                    kqVar.vGO = aVar3.Avy.ry();
                    return 0;
                case 5:
                    kqVar.ktm = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
