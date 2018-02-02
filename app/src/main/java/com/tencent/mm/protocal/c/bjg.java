package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bjg extends a {
    public String ksU;
    public String wMF;
    public int wMG;
    public String wMH;
    public int wMI;
    public int wvp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wMF != null) {
                aVar.g(1, this.wMF);
            }
            aVar.fU(2, this.wMG);
            if (this.ksU != null) {
                aVar.g(3, this.ksU);
            }
            if (this.wMH != null) {
                aVar.g(4, this.wMH);
            }
            aVar.fU(5, this.wvp);
            aVar.fU(6, this.wMI);
            return 0;
        } else if (i == 1) {
            if (this.wMF != null) {
                r0 = e.a.a.b.b.a.h(1, this.wMF) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wMG);
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(3, this.ksU);
            }
            if (this.wMH != null) {
                r0 += e.a.a.b.b.a.h(4, this.wMH);
            }
            return (r0 + e.a.a.a.fR(5, this.wvp)) + e.a.a.a.fR(6, this.wMI);
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
            bjg com_tencent_mm_protocal_c_bjg = (bjg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bjg.wMF = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjg.wMG = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjg.ksU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjg.wMH = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjg.wvp = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjg.wMI = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
