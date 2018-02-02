package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class alb extends a {
    public String pbN;
    public String pek;
    public String wil;
    public String wsj;
    public String wsk;
    public String wsl;
    public String wsm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pek == null) {
                throw new b("Not all required fields were included: product_id");
            } else if (this.pbN == null) {
                throw new b("Not all required fields were included: price");
            } else if (this.wil == null) {
                throw new b("Not all required fields were included: currency_type");
            } else if (this.wsj == null) {
                throw new b("Not all required fields were included: session_data");
            } else {
                if (this.pek != null) {
                    aVar.g(1, this.pek);
                }
                if (this.pbN != null) {
                    aVar.g(2, this.pbN);
                }
                if (this.wil != null) {
                    aVar.g(3, this.wil);
                }
                if (this.wsj != null) {
                    aVar.g(4, this.wsj);
                }
                if (this.wsk != null) {
                    aVar.g(5, this.wsk);
                }
                if (this.wsl != null) {
                    aVar.g(6, this.wsl);
                }
                if (this.wsm == null) {
                    return 0;
                }
                aVar.g(7, this.wsm);
                return 0;
            }
        } else if (i == 1) {
            if (this.pek != null) {
                r0 = e.a.a.b.b.a.h(1, this.pek) + 0;
            } else {
                r0 = 0;
            }
            if (this.pbN != null) {
                r0 += e.a.a.b.b.a.h(2, this.pbN);
            }
            if (this.wil != null) {
                r0 += e.a.a.b.b.a.h(3, this.wil);
            }
            if (this.wsj != null) {
                r0 += e.a.a.b.b.a.h(4, this.wsj);
            }
            if (this.wsk != null) {
                r0 += e.a.a.b.b.a.h(5, this.wsk);
            }
            if (this.wsl != null) {
                r0 += e.a.a.b.b.a.h(6, this.wsl);
            }
            if (this.wsm != null) {
                r0 += e.a.a.b.b.a.h(7, this.wsm);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.pek == null) {
                throw new b("Not all required fields were included: product_id");
            } else if (this.pbN == null) {
                throw new b("Not all required fields were included: price");
            } else if (this.wil == null) {
                throw new b("Not all required fields were included: currency_type");
            } else if (this.wsj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: session_data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alb com_tencent_mm_protocal_c_alb = (alb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_alb.pek = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alb.pbN = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alb.wil = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alb.wsj = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alb.wsk = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alb.wsl = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_alb.wsm = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
