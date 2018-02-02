package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class byu extends a {
    public String fon;
    public String nje;
    public int nkn;
    public String wYG;
    public int wYS;
    public boolean wYT;
    public boolean wYU;
    public boolean wYV;
    public b wYy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYG == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            } else if (this.fon == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.nje == null) {
                throw new e.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.fU(1, this.nkn);
                if (this.wYG != null) {
                    aVar.g(2, this.wYG);
                }
                if (this.fon != null) {
                    aVar.g(3, this.fon);
                }
                if (this.nje != null) {
                    aVar.g(4, this.nje);
                }
                aVar.fU(5, this.wYS);
                if (this.wYy != null) {
                    aVar.b(6, this.wYy);
                }
                aVar.al(7, this.wYT);
                aVar.al(8, this.wYU);
                aVar.al(9, this.wYV);
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.nkn) + 0;
            if (this.wYG != null) {
                r0 += e.a.a.b.b.a.h(2, this.wYG);
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(4, this.nje);
            }
            r0 += e.a.a.a.fR(5, this.wYS);
            if (this.wYy != null) {
                r0 += e.a.a.a.a(6, this.wYy);
            }
            return ((r0 + (e.a.a.b.b.a.dX(7) + 1)) + (e.a.a.b.b.a.dX(8) + 1)) + (e.a.a.b.b.a.dX(9) + 1);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYG == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            } else if (this.fon == null) {
                throw new e.a.a.b("Not all required fields were included: Title");
            } else if (this.nje != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byu com_tencent_mm_protocal_c_byu = (byu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_byu.nkn = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_byu.wYG = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_byu.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_byu.nje = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_byu.wYS = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_byu.wYy = aVar3.cJD();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_byu.wYT = aVar3.cJC();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_byu.wYU = aVar3.cJC();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_byu.wYV = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
