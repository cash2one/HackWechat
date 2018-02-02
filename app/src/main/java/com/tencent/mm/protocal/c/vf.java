package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class vf extends a {
    public String fon;
    public String nfe;
    public int vGR;
    public String vGS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(2, this.nfe);
            }
            aVar.fU(3, this.vGR);
            if (this.vGS == null) {
                return 0;
            }
            aVar.g(4, this.vGS);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            r0 += e.a.a.a.fR(3, this.vGR);
            if (this.vGS != null) {
                r0 += e.a.a.b.b.a.h(4, this.vGS);
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
            vf vfVar = (vf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vfVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    vfVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    vfVar.vGR = aVar3.Avy.ry();
                    return 0;
                case 4:
                    vfVar.vGS = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
