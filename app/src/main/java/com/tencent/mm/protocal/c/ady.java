package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ady extends bcv {
    public int rYW;
    public int vDW;
    public double vNO;
    public double vNP;
    public String wgS;
    public bdn wlO;
    public int wlQ;
    public double wmt;
    public double wmu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wlO == null) {
                throw new b("Not all required fields were included: Buff");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.rYW);
            aVar.fU(3, this.vDW);
            if (this.wgS != null) {
                aVar.g(4, this.wgS);
            }
            if (this.wlO != null) {
                aVar.fW(5, this.wlO.bke());
                this.wlO.a(aVar);
            }
            aVar.b(6, this.vNO);
            aVar.b(7, this.vNP);
            aVar.b(8, this.wmt);
            aVar.b(9, this.wmu);
            aVar.fU(10, this.wlQ);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.rYW)) + e.a.a.a.fR(3, this.vDW);
            if (this.wgS != null) {
                r0 += e.a.a.b.b.a.h(4, this.wgS);
            }
            if (this.wlO != null) {
                r0 += e.a.a.a.fT(5, this.wlO.bke());
            }
            return ((((r0 + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8)) + (e.a.a.b.b.a.dX(8) + 8)) + (e.a.a.b.b.a.dX(9) + 8)) + e.a.a.a.fR(10, this.wlQ);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wlO != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buff");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ady com_tencent_mm_protocal_c_ady = (ady) objArr[1];
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
                        com_tencent_mm_protocal_c_ady.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ady.rYW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ady.vDW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ady.wgS = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ady.wlO = fdVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ady.vNO = aVar3.Avy.readDouble();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ady.vNP = aVar3.Avy.readDouble();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ady.wmt = aVar3.Avy.readDouble();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ady.wmu = aVar3.Avy.readDouble();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ady.wlQ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
