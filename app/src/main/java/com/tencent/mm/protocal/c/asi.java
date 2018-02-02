package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class asi extends a {
    public int vOc;
    public String vUU;
    public String vUV;
    public int wzP;
    public b wzQ;
    public String wzR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vOc);
            aVar.fU(2, this.wzP);
            if (this.wzQ != null) {
                aVar.b(3, this.wzQ);
            }
            if (this.wzR != null) {
                aVar.g(4, this.wzR);
            }
            if (this.vUU != null) {
                aVar.g(5, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(6, this.vUV);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.vOc) + 0) + e.a.a.a.fR(2, this.wzP);
            if (this.wzQ != null) {
                r0 += e.a.a.a.a(3, this.wzQ);
            }
            if (this.wzR != null) {
                r0 += e.a.a.b.b.a.h(4, this.wzR);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(5, this.vUU);
            }
            if (this.vUV != null) {
                return r0 + e.a.a.b.b.a.h(6, this.vUV);
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
            asi com_tencent_mm_protocal_c_asi = (asi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_asi.vOc = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asi.wzP = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asi.wzQ = aVar3.cJD();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asi.wzR = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asi.vUU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asi.vUV = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
