package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class atr extends bdf {
    public String hcp;
    public String vUP;
    public LinkedList<ats> wBJ = new LinkedList();
    public String wBK;
    public boolean wBL;
    public boolean wBM;
    public boolean wBN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.d(3, 8, this.wBJ);
            if (this.hcp != null) {
                aVar.g(4, this.hcp);
            }
            if (this.wBK != null) {
                aVar.g(5, this.wBK);
            }
            if (this.vUP != null) {
                aVar.g(6, this.vUP);
            }
            aVar.al(8, this.wBL);
            aVar.al(9, this.wBM);
            aVar.al(10, this.wBN);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.c(3, 8, this.wBJ);
            if (this.hcp != null) {
                r0 += e.a.a.b.b.a.h(4, this.hcp);
            }
            if (this.wBK != null) {
                r0 += e.a.a.b.b.a.h(5, this.wBK);
            }
            if (this.vUP != null) {
                r0 += e.a.a.b.b.a.h(6, this.vUP);
            }
            return ((r0 + (e.a.a.b.b.a.dX(8) + 1)) + (e.a.a.b.b.a.dX(9) + 1)) + (e.a.a.b.b.a.dX(10) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wBJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atr com_tencent_mm_protocal_c_atr = (atr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.wJr = feVar;
                    }
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new ats();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atr.wBJ.add(feVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_atr.hcp = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_atr.wBK = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_atr.vUP = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_atr.wBL = aVar3.cJC();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_atr.wBM = aVar3.cJC();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_atr.wBN = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
