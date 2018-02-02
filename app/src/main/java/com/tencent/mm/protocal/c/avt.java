package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class avt extends a {
    public String fFm;
    public String kJP;
    public String vRF;
    public int wDu;
    public String wDv;
    public String wDw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fFm != null) {
                aVar.g(1, this.fFm);
            }
            aVar.fU(2, this.wDu);
            if (this.wDv != null) {
                aVar.g(3, this.wDv);
            }
            if (this.wDw != null) {
                aVar.g(4, this.wDw);
            }
            if (this.vRF != null) {
                aVar.g(5, this.vRF);
            }
            if (this.kJP == null) {
                return 0;
            }
            aVar.g(6, this.kJP);
            return 0;
        } else if (i == 1) {
            if (this.fFm != null) {
                r0 = e.a.a.b.b.a.h(1, this.fFm) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wDu);
            if (this.wDv != null) {
                r0 += e.a.a.b.b.a.h(3, this.wDv);
            }
            if (this.wDw != null) {
                r0 += e.a.a.b.b.a.h(4, this.wDw);
            }
            if (this.vRF != null) {
                r0 += e.a.a.b.b.a.h(5, this.vRF);
            }
            if (this.kJP != null) {
                r0 += e.a.a.b.b.a.h(6, this.kJP);
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
            avt com_tencent_mm_protocal_c_avt = (avt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avt.fFm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avt.wDu = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avt.wDv = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avt.wDw = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avt.vRF = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avt.kJP = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
