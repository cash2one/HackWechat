package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class byq extends a {
    public int ngq;
    public String nje;
    public String wYG;
    public long wYH;
    public long wYM;
    public boolean wYN;
    public b wYO;
    public String wvW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wvW == null) {
                throw new e.a.a.b("Not all required fields were included: Nickname");
            } else if (this.nje == null) {
                throw new e.a.a.b("Not all required fields were included: Content");
            } else if (this.wYG == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            } else {
                aVar.S(1, this.wYH);
                if (this.wvW != null) {
                    aVar.g(2, this.wvW);
                }
                if (this.nje != null) {
                    aVar.g(3, this.nje);
                }
                aVar.fU(4, this.ngq);
                if (this.wYG != null) {
                    aVar.g(5, this.wYG);
                }
                aVar.S(6, this.wYM);
                aVar.al(7, this.wYN);
                if (this.wYO != null) {
                    aVar.b(8, this.wYO);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.R(1, this.wYH) + 0;
            if (this.wvW != null) {
                r0 += e.a.a.b.b.a.h(2, this.wvW);
            }
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(3, this.nje);
            }
            r0 += e.a.a.a.fR(4, this.ngq);
            if (this.wYG != null) {
                r0 += e.a.a.b.b.a.h(5, this.wYG);
            }
            r0 = (r0 + e.a.a.a.R(6, this.wYM)) + (e.a.a.b.b.a.dX(7) + 1);
            if (this.wYO != null) {
                return r0 + e.a.a.a.a(8, this.wYO);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wvW == null) {
                throw new e.a.a.b("Not all required fields were included: Nickname");
            } else if (this.nje == null) {
                throw new e.a.a.b("Not all required fields were included: Content");
            } else if (this.wYG != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Talker");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byq com_tencent_mm_protocal_c_byq = (byq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_byq.wYH = aVar3.Avy.rz();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_byq.wvW = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_byq.nje = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_byq.ngq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_byq.wYG = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_byq.wYM = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_byq.wYN = aVar3.cJC();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_byq.wYO = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
