package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bkw extends bcv {
    public String wMJ;
    public long wMK;
    public bdn wMo;
    public long wOg;
    public int wOh;
    public long wOi;
    public int wOj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wMJ != null) {
                aVar.g(2, this.wMJ);
            }
            aVar.S(3, this.wMK);
            aVar.S(4, this.wOg);
            aVar.fU(5, this.wOh);
            aVar.S(6, this.wOi);
            if (this.wMo != null) {
                aVar.fW(7, this.wMo.bke());
                this.wMo.a(aVar);
            }
            aVar.fU(8, this.wOj);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wMJ != null) {
                r0 += e.a.a.b.b.a.h(2, this.wMJ);
            }
            r0 = (((r0 + e.a.a.a.R(3, this.wMK)) + e.a.a.a.R(4, this.wOg)) + e.a.a.a.fR(5, this.wOh)) + e.a.a.a.R(6, this.wOi);
            if (this.wMo != null) {
                r0 += e.a.a.a.fT(7, this.wMo.bke());
            }
            return r0 + e.a.a.a.fR(8, this.wOj);
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
            bkw com_tencent_mm_protocal_c_bkw = (bkw) objArr[1];
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
                        com_tencent_mm_protocal_c_bkw.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkw.wMJ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkw.wMK = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkw.wOg = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkw.wOh = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkw.wOi = aVar3.Avy.rz();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkw.wMo = fdVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bkw.wOj = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
