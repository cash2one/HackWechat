package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bkk extends a {
    public int wJd;
    public int wNQ;
    public LinkedList<bjr> wNR = new LinkedList();
    public int wNS;
    public int wNT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wNQ);
            aVar.d(2, 8, this.wNR);
            aVar.fU(3, this.wNS);
            aVar.fU(4, this.wJd);
            aVar.fU(5, this.wNT);
            return 0;
        } else if (i == 1) {
            return ((((e.a.a.a.fR(1, this.wNQ) + 0) + e.a.a.a.c(2, 8, this.wNR)) + e.a.a.a.fR(3, this.wNS)) + e.a.a.a.fR(4, this.wJd)) + e.a.a.a.fR(5, this.wNT);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.wNR.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
                bkk com_tencent_mm_protocal_c_bkk = (bkk) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        com_tencent_mm_protocal_c_bkk.wNQ = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        LinkedList Jl = aVar3.Jl(intValue);
                        int size = Jl.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) Jl.get(intValue);
                            a com_tencent_mm_protocal_c_bjr = new bjr();
                            e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = com_tencent_mm_protocal_c_bjr.a(aVar4, com_tencent_mm_protocal_c_bjr, a.a(aVar4))) {
                            }
                            com_tencent_mm_protocal_c_bkk.wNR.add(com_tencent_mm_protocal_c_bjr);
                        }
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bkk.wNS = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bkk.wJd = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_bkk.wNT = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
