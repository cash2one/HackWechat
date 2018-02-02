package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bst extends a {
    public String fFm;
    public String fqD;
    public String kUd;
    public String wTU;
    public String wsG;
    public String wsp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fFm != null) {
                aVar.g(1, this.fFm);
            }
            if (this.fqD != null) {
                aVar.g(2, this.fqD);
            }
            if (this.wsG != null) {
                aVar.g(3, this.wsG);
            }
            if (this.wTU != null) {
                aVar.g(4, this.wTU);
            }
            if (this.kUd != null) {
                aVar.g(5, this.kUd);
            }
            if (this.wsp == null) {
                return 0;
            }
            aVar.g(6, this.wsp);
            return 0;
        } else if (i == 1) {
            if (this.fFm != null) {
                r0 = e.a.a.b.b.a.h(1, this.fFm) + 0;
            } else {
                r0 = 0;
            }
            if (this.fqD != null) {
                r0 += e.a.a.b.b.a.h(2, this.fqD);
            }
            if (this.wsG != null) {
                r0 += e.a.a.b.b.a.h(3, this.wsG);
            }
            if (this.wTU != null) {
                r0 += e.a.a.b.b.a.h(4, this.wTU);
            }
            if (this.kUd != null) {
                r0 += e.a.a.b.b.a.h(5, this.kUd);
            }
            if (this.wsp != null) {
                r0 += e.a.a.b.b.a.h(6, this.wsp);
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
            bst com_tencent_mm_protocal_c_bst = (bst) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bst.fFm = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bst.fqD = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bst.wsG = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bst.wTU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bst.kUd = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bst.wsp = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
