package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bnc extends bcv {
    public int rYW;
    public int vGO;
    public int wbh;
    public long wbi;
    public int wgQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wbh);
            aVar.S(3, this.wbi);
            aVar.fU(4, this.wgQ);
            aVar.fU(5, this.vGO);
            aVar.fU(6, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            return ((((r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.R(3, this.wbi)) + e.a.a.a.fR(4, this.wgQ)) + e.a.a.a.fR(5, this.vGO)) + e.a.a.a.fR(6, this.rYW);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bnc com_tencent_mm_protocal_c_bnc = (bnc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bnc.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnc.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnc.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnc.wgQ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bnc.vGO = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bnc.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
