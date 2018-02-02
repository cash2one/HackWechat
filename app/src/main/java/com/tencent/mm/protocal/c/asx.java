package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class asx extends a {
    public String wAH;
    public String wAI;
    public int wAJ;
    public int wAK;
    public int wAL;
    public int wAM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wAH != null) {
                aVar.g(1, this.wAH);
            }
            if (this.wAI != null) {
                aVar.g(2, this.wAI);
            }
            aVar.fU(3, this.wAJ);
            aVar.fU(4, this.wAK);
            aVar.fU(5, this.wAL);
            aVar.fU(7, this.wAM);
            return 0;
        } else if (i == 1) {
            if (this.wAH != null) {
                r0 = e.a.a.b.b.a.h(1, this.wAH) + 0;
            } else {
                r0 = 0;
            }
            if (this.wAI != null) {
                r0 += e.a.a.b.b.a.h(2, this.wAI);
            }
            return (((r0 + e.a.a.a.fR(3, this.wAJ)) + e.a.a.a.fR(4, this.wAK)) + e.a.a.a.fR(5, this.wAL)) + e.a.a.a.fR(7, this.wAM);
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
            asx com_tencent_mm_protocal_c_asx = (asx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_asx.wAH = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asx.wAI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asx.wAJ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asx.wAK = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asx.wAL = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asx.wAM = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
