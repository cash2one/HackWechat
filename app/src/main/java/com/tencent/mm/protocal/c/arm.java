package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class arm extends a {
    public String ksU;
    public int pQk;
    public String vYJ;
    public int wza;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vYJ != null) {
                aVar.g(1, this.vYJ);
            }
            if (this.ksU != null) {
                aVar.g(2, this.ksU);
            }
            aVar.fU(3, this.wza);
            aVar.fU(4, this.pQk);
            return 0;
        } else if (i == 1) {
            if (this.vYJ != null) {
                r0 = e.a.a.b.b.a.h(1, this.vYJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            return (r0 + e.a.a.a.fR(3, this.wza)) + e.a.a.a.fR(4, this.pQk);
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
            arm com_tencent_mm_protocal_c_arm = (arm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_arm.vYJ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arm.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arm.wza = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arm.pQk = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
