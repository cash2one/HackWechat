package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bou extends a {
    public int wRj;
    public int wRk;
    public String wRl;
    public b wRm;
    public int wRn;
    public int wRo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wRj);
            aVar.fU(2, this.wRk);
            if (this.wRl != null) {
                aVar.g(3, this.wRl);
            }
            if (this.wRm != null) {
                aVar.b(4, this.wRm);
            }
            aVar.fU(5, this.wRn);
            aVar.fU(6, this.wRo);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.wRj) + 0) + e.a.a.a.fR(2, this.wRk);
            if (this.wRl != null) {
                r0 += e.a.a.b.b.a.h(3, this.wRl);
            }
            if (this.wRm != null) {
                r0 += e.a.a.a.a(4, this.wRm);
            }
            return (r0 + e.a.a.a.fR(5, this.wRn)) + e.a.a.a.fR(6, this.wRo);
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
            bou com_tencent_mm_protocal_c_bou = (bou) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bou.wRj = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bou.wRk = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bou.wRl = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bou.wRm = aVar3.cJD();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bou.wRn = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bou.wRo = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
