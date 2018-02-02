package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class alf extends a {
    public int key;
    public int length;
    public long wst;
    public int wsu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.key);
            aVar.S(2, this.wst);
            aVar.fU(3, this.length);
            aVar.fU(4, this.wsu);
            return 0;
        } else if (i == 1) {
            return (((e.a.a.a.fR(1, this.key) + 0) + e.a.a.a.R(2, this.wst)) + e.a.a.a.fR(3, this.length)) + e.a.a.a.fR(4, this.wsu);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                alf com_tencent_mm_protocal_c_alf = (alf) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_alf.key = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_alf.wst = aVar3.Avy.rz();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_alf.length = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_alf.wsu = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
