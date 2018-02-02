package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class jt extends a {
    public String vKW;
    public String vQF;
    public int vQG;
    public String vQH;
    public String vQI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQF != null) {
                aVar.g(1, this.vQF);
            }
            aVar.fU(2, this.vQG);
            if (this.vQH != null) {
                aVar.g(3, this.vQH);
            }
            if (this.vKW != null) {
                aVar.g(4, this.vKW);
            }
            if (this.vQI == null) {
                return 0;
            }
            aVar.g(5, this.vQI);
            return 0;
        } else if (i == 1) {
            if (this.vQF != null) {
                r0 = e.a.a.b.b.a.h(1, this.vQF) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vQG);
            if (this.vQH != null) {
                r0 += e.a.a.b.b.a.h(3, this.vQH);
            }
            if (this.vKW != null) {
                r0 += e.a.a.b.b.a.h(4, this.vKW);
            }
            if (this.vQI != null) {
                r0 += e.a.a.b.b.a.h(5, this.vQI);
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
            jt jtVar = (jt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jtVar.vQF = aVar3.Avy.readString();
                    return 0;
                case 2:
                    jtVar.vQG = aVar3.Avy.ry();
                    return 0;
                case 3:
                    jtVar.vQH = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jtVar.vKW = aVar3.Avy.readString();
                    return 0;
                case 5:
                    jtVar.vQI = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
