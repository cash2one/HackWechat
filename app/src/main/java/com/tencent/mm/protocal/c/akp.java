package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class akp extends a {
    public String fon;
    public String nfX;
    public String niZ;
    public String wrO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfX != null) {
                aVar.g(1, this.nfX);
            }
            if (this.fon != null) {
                aVar.g(2, this.fon);
            }
            if (this.wrO != null) {
                aVar.g(3, this.wrO);
            }
            if (this.niZ == null) {
                return 0;
            }
            aVar.g(4, this.niZ);
            return 0;
        } else if (i == 1) {
            if (this.nfX != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfX) + 0;
            } else {
                r0 = 0;
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.wrO != null) {
                r0 += e.a.a.b.b.a.h(3, this.wrO);
            }
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(4, this.niZ);
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
            akp com_tencent_mm_protocal_c_akp = (akp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akp.nfX = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akp.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akp.wrO = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akp.niZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
