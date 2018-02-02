package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bzn extends a {
    public String kub;
    public String wYG;
    public b wYy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYG == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            } else if (this.kub == null) {
                throw new e.a.a.b("Not all required fields were included: NickName");
            } else {
                if (this.wYG != null) {
                    aVar.g(1, this.wYG);
                }
                if (this.kub != null) {
                    aVar.g(2, this.kub);
                }
                if (this.wYy == null) {
                    return 0;
                }
                aVar.b(3, this.wYy);
                return 0;
            }
        } else if (i == 1) {
            if (this.wYG != null) {
                r0 = e.a.a.b.b.a.h(1, this.wYG) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            if (this.wYy != null) {
                r0 += e.a.a.a.a(3, this.wYy);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYG == null) {
                throw new e.a.a.b("Not all required fields were included: Talker");
            } else if (this.kub != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzn com_tencent_mm_protocal_c_bzn = (bzn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bzn.wYG = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzn.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzn.wYy = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
