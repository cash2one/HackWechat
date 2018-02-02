package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bec extends a {
    public String jgw;
    public String nfe;
    public String vOl;
    public int wJQ;
    public String wsF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vOl != null) {
                aVar.g(1, this.vOl);
            }
            if (this.nfe != null) {
                aVar.g(2, this.nfe);
            }
            aVar.fU(3, this.wJQ);
            if (this.jgw != null) {
                aVar.g(4, this.jgw);
            }
            if (this.wsF == null) {
                return 0;
            }
            aVar.g(5, this.wsF);
            return 0;
        } else if (i == 1) {
            if (this.vOl != null) {
                r0 = e.a.a.b.b.a.h(1, this.vOl) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            r0 += e.a.a.a.fR(3, this.wJQ);
            if (this.jgw != null) {
                r0 += e.a.a.b.b.a.h(4, this.jgw);
            }
            if (this.wsF != null) {
                r0 += e.a.a.b.b.a.h(5, this.wsF);
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
            bec com_tencent_mm_protocal_c_bec = (bec) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bec.vOl = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bec.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bec.wJQ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bec.jgw = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bec.wsF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
