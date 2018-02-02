package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ays extends bcv {
    public String wFM;
    public int wFN;
    public int wFO;
    public long wFp;
    public long wFs;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wFM == null) {
                throw new b("Not all required fields were included: FromUsername");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wFM != null) {
                aVar.g(2, this.wFM);
            }
            aVar.fU(3, this.wbh);
            aVar.S(4, this.wbi);
            aVar.S(5, this.wFp);
            aVar.fU(6, this.wFN);
            aVar.S(7, this.wFs);
            aVar.fU(8, this.wFO);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wFM != null) {
                r0 += e.a.a.b.b.a.h(2, this.wFM);
            }
            return (((((r0 + e.a.a.a.fR(3, this.wbh)) + e.a.a.a.R(4, this.wbi)) + e.a.a.a.R(5, this.wFp)) + e.a.a.a.fR(6, this.wFN)) + e.a.a.a.R(7, this.wFs)) + e.a.a.a.fR(8, this.wFO);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wFM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: FromUsername");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ays com_tencent_mm_protocal_c_ays = (ays) objArr[1];
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
                        com_tencent_mm_protocal_c_ays.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ays.wFM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ays.wbh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ays.wbi = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ays.wFp = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ays.wFN = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ays.wFs = aVar3.Avy.rz();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ays.wFO = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
