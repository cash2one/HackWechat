package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afa extends bcv {
    public int wmR;
    public bdn wmS;
    public int wmT;
    public int wmU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wmS == null) {
                throw new b("Not all required fields were included: Url");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wmR);
            if (this.wmS != null) {
                aVar.fW(3, this.wmS.bke());
                this.wmS.a(aVar);
            }
            aVar.fU(4, this.wmT);
            aVar.fU(5, this.wmU);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.wmR);
            if (this.wmS != null) {
                r0 += e.a.a.a.fT(3, this.wmS.bke());
            }
            return (r0 + e.a.a.a.fR(4, this.wmT)) + e.a.a.a.fR(5, this.wmU);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wmS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Url");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afa com_tencent_mm_protocal_c_afa = (afa) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afa.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afa.wmR = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afa.wmS = fdVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afa.wmT = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afa.wmU = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
