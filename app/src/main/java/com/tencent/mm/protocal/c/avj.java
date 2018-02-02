package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class avj extends a {
    public String kJT;
    public String kUd;
    public String kUf;
    public String sMr;
    public String wCZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kJT != null) {
                aVar.g(1, this.kJT);
            }
            if (this.sMr != null) {
                aVar.g(2, this.sMr);
            }
            if (this.kUf != null) {
                aVar.g(3, this.kUf);
            }
            if (this.kUd != null) {
                aVar.g(4, this.kUd);
            }
            if (this.wCZ == null) {
                return 0;
            }
            aVar.g(5, this.wCZ);
            return 0;
        } else if (i == 1) {
            if (this.kJT != null) {
                r0 = e.a.a.b.b.a.h(1, this.kJT) + 0;
            } else {
                r0 = 0;
            }
            if (this.sMr != null) {
                r0 += e.a.a.b.b.a.h(2, this.sMr);
            }
            if (this.kUf != null) {
                r0 += e.a.a.b.b.a.h(3, this.kUf);
            }
            if (this.kUd != null) {
                r0 += e.a.a.b.b.a.h(4, this.kUd);
            }
            if (this.wCZ != null) {
                r0 += e.a.a.b.b.a.h(5, this.wCZ);
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
            avj com_tencent_mm_protocal_c_avj = (avj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avj.kJT = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avj.sMr = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avj.kUf = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avj.kUd = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avj.wCZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
