package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class asr extends a {
    public String fon;
    public String ksU;
    public String nfe;
    public long vHe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon != null) {
                aVar.g(1, this.fon);
            }
            if (this.nfe != null) {
                aVar.g(2, this.nfe);
            }
            if (this.ksU != null) {
                aVar.g(3, this.ksU);
            }
            aVar.S(4, this.vHe);
            return 0;
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(3, this.ksU);
            }
            return r0 + e.a.a.a.R(4, this.vHe);
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
            asr com_tencent_mm_protocal_c_asr = (asr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_asr.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asr.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asr.ksU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asr.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
