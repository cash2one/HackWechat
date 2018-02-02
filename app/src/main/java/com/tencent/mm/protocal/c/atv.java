package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class atv extends bcv {
    public String nGJ;
    public String sPj;
    public au vQS;
    public int wBR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wBR);
            if (this.nGJ != null) {
                aVar.g(3, this.nGJ);
            }
            if (this.sPj != null) {
                aVar.g(4, this.sPj);
            }
            if (this.vQS == null) {
                return 0;
            }
            aVar.fW(5, this.vQS.bke());
            this.vQS.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wBR);
            if (this.nGJ != null) {
                r0 += e.a.a.b.b.a.h(3, this.nGJ);
            }
            if (this.sPj != null) {
                r0 += e.a.a.b.b.a.h(4, this.sPj);
            }
            if (this.vQS != null) {
                r0 += e.a.a.a.fT(5, this.vQS.bke());
            }
            return r0;
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
            atv com_tencent_mm_protocal_c_atv = (atv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atv.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atv.wBR = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_atv.nGJ = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_atv.sPj = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new au();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atv.vQS = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
