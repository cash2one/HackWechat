package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bof extends a {
    public String vQE;
    public String vZO;
    public int wQM;
    public int wQN;
    public long wQO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wQM);
            if (this.vQE != null) {
                aVar.g(2, this.vQE);
            }
            if (this.vZO != null) {
                aVar.g(3, this.vZO);
            }
            aVar.fU(4, this.wQN);
            aVar.S(5, this.wQO);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wQM) + 0;
            if (this.vQE != null) {
                r0 += e.a.a.b.b.a.h(2, this.vQE);
            }
            if (this.vZO != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZO);
            }
            return (r0 + e.a.a.a.fR(4, this.wQN)) + e.a.a.a.R(5, this.wQO);
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
            bof com_tencent_mm_protocal_c_bof = (bof) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bof.wQM = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bof.vQE = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bof.vZO = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bof.wQN = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bof.wQO = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
