package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aud extends a {
    public String hJu;
    public int vOI;
    public int vWK;
    public int vYh;
    public int wCd;
    public int wCe;
    public String wCf;
    public int wCg;
    public String wCh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hJu != null) {
                aVar.g(1, this.hJu);
            }
            aVar.fU(2, this.wCd);
            aVar.fU(3, this.wCe);
            aVar.fU(4, this.vOI);
            if (this.wCf != null) {
                aVar.g(5, this.wCf);
            }
            aVar.fU(6, this.vYh);
            aVar.fU(7, this.wCg);
            aVar.fU(8, this.vWK);
            if (this.wCh == null) {
                return 0;
            }
            aVar.g(9, this.wCh);
            return 0;
        } else if (i == 1) {
            if (this.hJu != null) {
                r0 = e.a.a.b.b.a.h(1, this.hJu) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.wCd)) + e.a.a.a.fR(3, this.wCe)) + e.a.a.a.fR(4, this.vOI);
            if (this.wCf != null) {
                r0 += e.a.a.b.b.a.h(5, this.wCf);
            }
            r0 = ((r0 + e.a.a.a.fR(6, this.vYh)) + e.a.a.a.fR(7, this.wCg)) + e.a.a.a.fR(8, this.vWK);
            if (this.wCh != null) {
                r0 += e.a.a.b.b.a.h(9, this.wCh);
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
            aud com_tencent_mm_protocal_c_aud = (aud) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aud.hJu = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aud.wCd = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aud.wCe = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aud.vOI = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aud.wCf = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aud.vYh = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aud.wCg = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aud.vWK = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aud.wCh = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
