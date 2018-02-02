package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class cbp extends a {
    public String fFm;
    public int type;
    public String xaG;
    public String xaH;
    public int xaI;
    public int xaJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.type);
            if (this.fFm != null) {
                aVar.g(2, this.fFm);
            }
            if (this.xaG != null) {
                aVar.g(3, this.xaG);
            }
            if (this.xaH != null) {
                aVar.g(4, this.xaH);
            }
            aVar.fU(5, this.xaI);
            aVar.fU(6, this.xaJ);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.type) + 0;
            if (this.fFm != null) {
                r0 += e.a.a.b.b.a.h(2, this.fFm);
            }
            if (this.xaG != null) {
                r0 += e.a.a.b.b.a.h(3, this.xaG);
            }
            if (this.xaH != null) {
                r0 += e.a.a.b.b.a.h(4, this.xaH);
            }
            return (r0 + e.a.a.a.fR(5, this.xaI)) + e.a.a.a.fR(6, this.xaJ);
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
            cbp com_tencent_mm_protocal_c_cbp = (cbp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_cbp.type = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbp.fFm = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_cbp.xaG = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_cbp.xaH = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_cbp.xaI = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_cbp.xaJ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
