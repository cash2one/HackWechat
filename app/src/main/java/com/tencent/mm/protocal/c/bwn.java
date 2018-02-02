package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bwn extends a {
    public String nfZ;
    public String nkp;
    public String wEW;
    public String wXE;
    public String wXF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wEW != null) {
                aVar.g(1, this.wEW);
            }
            if (this.wXE != null) {
                aVar.g(2, this.wXE);
            }
            if (this.nkp != null) {
                aVar.g(3, this.nkp);
            }
            if (this.nfZ != null) {
                aVar.g(4, this.nfZ);
            }
            if (this.wXF == null) {
                return 0;
            }
            aVar.g(5, this.wXF);
            return 0;
        } else if (i == 1) {
            if (this.wEW != null) {
                r0 = e.a.a.b.b.a.h(1, this.wEW) + 0;
            } else {
                r0 = 0;
            }
            if (this.wXE != null) {
                r0 += e.a.a.b.b.a.h(2, this.wXE);
            }
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(3, this.nkp);
            }
            if (this.nfZ != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfZ);
            }
            if (this.wXF != null) {
                r0 += e.a.a.b.b.a.h(5, this.wXF);
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
            bwn com_tencent_mm_protocal_c_bwn = (bwn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bwn.wEW = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bwn.wXE = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bwn.nkp = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bwn.nfZ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bwn.wXF = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
