package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class bro extends a {
    public String hvy;
    public String ksU;
    public String kub;
    public String vIO;
    public String vXO;
    public String wTn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.wTn == null) {
                throw new b("Not all required fields were included: MatchWord");
            } else {
                if (this.ksU != null) {
                    aVar.g(1, this.ksU);
                }
                if (this.wTn != null) {
                    aVar.g(2, this.wTn);
                }
                if (this.kub != null) {
                    aVar.g(3, this.kub);
                }
                if (this.vXO != null) {
                    aVar.g(4, this.vXO);
                }
                if (this.hvy != null) {
                    aVar.g(5, this.hvy);
                }
                if (this.vIO == null) {
                    return 0;
                }
                aVar.g(6, this.vIO);
                return 0;
            }
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.wTn != null) {
                r0 += e.a.a.b.b.a.h(2, this.wTn);
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(3, this.kub);
            }
            if (this.vXO != null) {
                r0 += e.a.a.b.b.a.h(4, this.vXO);
            }
            if (this.hvy != null) {
                r0 += e.a.a.b.b.a.h(5, this.hvy);
            }
            if (this.vIO != null) {
                r0 += e.a.a.b.b.a.h(6, this.vIO);
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
                throw new b("Not all required fields were included: UserName");
            } else if (this.wTn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MatchWord");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bro com_tencent_mm_protocal_c_bro = (bro) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bro.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bro.wTn = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bro.kub = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bro.vXO = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bro.hvy = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bro.vIO = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
