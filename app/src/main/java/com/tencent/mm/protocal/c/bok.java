package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bok extends bcv {
    public String vJA;
    public String vXI;
    public akl wQR;
    public int wQS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vXI != null) {
                aVar.g(2, this.vXI);
            }
            if (this.vJA != null) {
                aVar.g(3, this.vJA);
            }
            if (this.wQR != null) {
                aVar.fW(4, this.wQR.bke());
                this.wQR.a(aVar);
            }
            aVar.fU(5, this.wQS);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vXI != null) {
                r0 += e.a.a.b.b.a.h(2, this.vXI);
            }
            if (this.vJA != null) {
                r0 += e.a.a.b.b.a.h(3, this.vJA);
            }
            if (this.wQR != null) {
                r0 += e.a.a.a.fT(4, this.wQR.bke());
            }
            return r0 + e.a.a.a.fR(5, this.wQS);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bok com_tencent_mm_protocal_c_bok = (bok) objArr[1];
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
                        com_tencent_mm_protocal_c_bok.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bok.vXI = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bok.vJA = aVar3.Avy.readString();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new akl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bok.wQR = fdVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bok.wQS = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
