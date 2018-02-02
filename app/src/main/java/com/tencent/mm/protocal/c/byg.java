package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class byg extends a {
    public String ksU;
    public String kub;
    public String nje;
    public int nkn;
    public b wYy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU == null) {
                throw new e.a.a.b("Not all required fields were included: UserName");
            } else if (this.kub == null) {
                throw new e.a.a.b("Not all required fields were included: NickName");
            } else if (this.nje == null) {
                throw new e.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.fU(1, this.nkn);
                if (this.ksU != null) {
                    aVar.g(2, this.ksU);
                }
                if (this.kub != null) {
                    aVar.g(3, this.kub);
                }
                if (this.nje != null) {
                    aVar.g(4, this.nje);
                }
                if (this.wYy != null) {
                    aVar.b(5, this.wYy);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.nkn) + 0;
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(3, this.kub);
            }
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(4, this.nje);
            }
            if (this.wYy != null) {
                return r0 + e.a.a.a.a(5, this.wYy);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksU == null) {
                throw new e.a.a.b("Not all required fields were included: UserName");
            } else if (this.kub == null) {
                throw new e.a.a.b("Not all required fields were included: NickName");
            } else if (this.nje != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byg com_tencent_mm_protocal_c_byg = (byg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_byg.nkn = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_byg.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_byg.kub = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_byg.nje = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_byg.wYy = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
