package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aok extends a {
    public String ksU;
    public String kub;
    public String vUU;
    public String vUV;
    public String whR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            if (this.vUU != null) {
                aVar.g(3, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(4, this.vUV);
            }
            if (this.whR == null) {
                return 0;
            }
            aVar.g(5, this.whR);
            return 0;
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(3, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(4, this.vUV);
            }
            if (this.whR != null) {
                r0 += e.a.a.b.b.a.h(5, this.whR);
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
            aok com_tencent_mm_protocal_c_aok = (aok) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aok.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aok.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aok.vUU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aok.vUV = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aok.whR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
