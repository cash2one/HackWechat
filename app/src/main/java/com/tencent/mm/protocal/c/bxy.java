package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class bxy extends a {
    public String ksU;
    public int ktN;
    public String kub;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.kub == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.ksU != null) {
                    aVar.g(1, this.ksU);
                }
                if (this.kub != null) {
                    aVar.g(2, this.kub);
                }
                aVar.fU(3, this.ktN);
                return 0;
            }
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            return r0 + e.a.a.a.fR(3, this.ktN);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ksU == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.kub != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxy com_tencent_mm_protocal_c_bxy = (bxy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bxy.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bxy.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bxy.ktN = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
