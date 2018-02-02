package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ayu extends a {
    public int lOr;
    public String lOs;
    public int nDD;
    public String nDE;
    public int wEr;
    public int wFQ;
    public int wFR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wEr);
            aVar.fU(2, this.wFR);
            aVar.fU(3, this.wFQ);
            aVar.fU(4, this.lOr);
            if (this.lOs != null) {
                aVar.g(5, this.lOs);
            }
            aVar.fU(6, this.nDD);
            if (this.nDE != null) {
                aVar.g(7, this.nDE);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((e.a.a.a.fR(1, this.wEr) + 0) + e.a.a.a.fR(2, this.wFR)) + e.a.a.a.fR(3, this.wFQ)) + e.a.a.a.fR(4, this.lOr);
            if (this.lOs != null) {
                r0 += e.a.a.b.b.a.h(5, this.lOs);
            }
            r0 += e.a.a.a.fR(6, this.nDD);
            if (this.nDE != null) {
                return r0 + e.a.a.b.b.a.h(7, this.nDE);
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
            ayu com_tencent_mm_protocal_c_ayu = (ayu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ayu.wEr = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayu.wFR = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayu.wFQ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ayu.lOr = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ayu.lOs = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayu.nDD = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ayu.nDE = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
