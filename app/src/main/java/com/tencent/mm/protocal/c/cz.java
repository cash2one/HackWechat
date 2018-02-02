package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cz extends a {
    public long vId;
    public int vIe;
    public int vIf;
    public int vIg;
    public int vIh;
    public int vIi;
    public int vIj;
    public String vIk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.S(1, this.vId);
            aVar.fU(2, this.vIe);
            aVar.fU(3, this.vIf);
            aVar.fU(4, this.vIg);
            aVar.fU(5, this.vIh);
            aVar.fU(6, this.vIi);
            aVar.fU(7, this.vIj);
            if (this.vIk != null) {
                aVar.g(8, this.vIk);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((((((e.a.a.a.R(1, this.vId) + 0) + e.a.a.a.fR(2, this.vIe)) + e.a.a.a.fR(3, this.vIf)) + e.a.a.a.fR(4, this.vIg)) + e.a.a.a.fR(5, this.vIh)) + e.a.a.a.fR(6, this.vIi)) + e.a.a.a.fR(7, this.vIj);
            if (this.vIk != null) {
                return r0 + e.a.a.b.b.a.h(8, this.vIk);
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
            cz czVar = (cz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czVar.vId = aVar3.Avy.rz();
                    return 0;
                case 2:
                    czVar.vIe = aVar3.Avy.ry();
                    return 0;
                case 3:
                    czVar.vIf = aVar3.Avy.ry();
                    return 0;
                case 4:
                    czVar.vIg = aVar3.Avy.ry();
                    return 0;
                case 5:
                    czVar.vIh = aVar3.Avy.ry();
                    return 0;
                case 6:
                    czVar.vIi = aVar3.Avy.ry();
                    return 0;
                case 7:
                    czVar.vIj = aVar3.Avy.ry();
                    return 0;
                case 8:
                    czVar.vIk = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
