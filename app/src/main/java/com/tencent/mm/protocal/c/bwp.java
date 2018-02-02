package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bwp extends a {
    public String fon;
    public String nGK;
    public String nfe;
    public int vGN;
    public String vIR;
    public String wEW;
    public String wXI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.wEW != null) {
                aVar.g(2, this.wEW);
            }
            if (this.nGK != null) {
                aVar.g(3, this.nGK);
            }
            if (this.nfe != null) {
                aVar.g(4, this.nfe);
            }
            if (this.wXI != null) {
                aVar.g(5, this.wXI);
            }
            aVar.fU(6, this.vGN);
            if (this.vIR == null) {
                return 0;
            }
            aVar.g(7, this.vIR);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.wEW != null) {
                r0 += e.a.a.b.b.a.h(2, this.wEW);
            }
            if (this.nGK != null) {
                r0 += e.a.a.b.b.a.h(3, this.nGK);
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfe);
            }
            if (this.wXI != null) {
                r0 += e.a.a.b.b.a.h(5, this.wXI);
            }
            r0 += e.a.a.a.fR(6, this.vGN);
            if (this.vIR != null) {
                r0 += e.a.a.b.b.a.h(7, this.vIR);
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
            bwp com_tencent_mm_protocal_c_bwp = (bwp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bwp.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bwp.wEW = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bwp.nGK = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bwp.nfe = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bwp.wXI = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bwp.vGN = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bwp.vIR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
