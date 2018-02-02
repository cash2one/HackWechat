package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ayv extends a {
    public String fqR;
    public String fyG;
    public String url;
    public int version;
    public boolean wFS;
    public int wFT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.al(1, this.wFS);
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.fqR != null) {
                aVar.g(3, this.fqR);
            }
            aVar.fU(4, this.version);
            aVar.fU(5, this.wFT);
            if (this.fyG != null) {
                aVar.g(6, this.fyG);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.b.b.a.dX(1) + 1) + 0;
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.fqR != null) {
                r0 += e.a.a.b.b.a.h(3, this.fqR);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.version)) + e.a.a.a.fR(5, this.wFT);
            if (this.fyG != null) {
                return r0 + e.a.a.b.b.a.h(6, this.fyG);
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
            ayv com_tencent_mm_protocal_c_ayv = (ayv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ayv.wFS = aVar3.cJC();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayv.url = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayv.fqR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ayv.version = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ayv.wFT = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayv.fyG = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
