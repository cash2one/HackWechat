package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bod extends a {
    public String nfp;
    public double vNO;
    public double vNP;
    public String wCR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.b(1, this.vNP);
            aVar.b(2, this.vNO);
            if (this.nfp != null) {
                aVar.g(3, this.nfp);
            }
            if (this.wCR != null) {
                aVar.g(4, this.wCR);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.b.b.a.dX(1) + 8) + 0) + (e.a.a.b.b.a.dX(2) + 8);
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(3, this.nfp);
            }
            if (this.wCR != null) {
                return r0 + e.a.a.b.b.a.h(4, this.wCR);
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
            bod com_tencent_mm_protocal_c_bod = (bod) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bod.vNP = aVar3.Avy.readDouble();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bod.vNO = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bod.nfp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bod.wCR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
