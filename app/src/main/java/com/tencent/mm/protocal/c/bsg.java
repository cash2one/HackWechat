package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsg extends bcv {
    public int pbq;
    public String vIR;
    public String wEW;
    public String wEX;
    public int wEY;
    public String wEZ;
    public bdn wTA;
    public int wTB;
    public int wTC;
    public String wTD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wTA == null) {
                throw new b("Not all required fields were included: Receipt");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wTA != null) {
                aVar.fW(2, this.wTA.bke());
                this.wTA.a(aVar);
            }
            if (this.vIR != null) {
                aVar.g(3, this.vIR);
            }
            aVar.fU(4, this.wTB);
            aVar.fU(5, this.pbq);
            if (this.wEW != null) {
                aVar.g(6, this.wEW);
            }
            if (this.wEX != null) {
                aVar.g(7, this.wEX);
            }
            if (this.wEZ != null) {
                aVar.g(8, this.wEZ);
            }
            aVar.fU(9, this.wTC);
            if (this.wTD != null) {
                aVar.g(10, this.wTD);
            }
            aVar.fU(11, this.wEY);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wTA != null) {
                r0 += e.a.a.a.fT(2, this.wTA.bke());
            }
            if (this.vIR != null) {
                r0 += e.a.a.b.b.a.h(3, this.vIR);
            }
            r0 = (r0 + e.a.a.a.fR(4, this.wTB)) + e.a.a.a.fR(5, this.pbq);
            if (this.wEW != null) {
                r0 += e.a.a.b.b.a.h(6, this.wEW);
            }
            if (this.wEX != null) {
                r0 += e.a.a.b.b.a.h(7, this.wEX);
            }
            if (this.wEZ != null) {
                r0 += e.a.a.b.b.a.h(8, this.wEZ);
            }
            r0 += e.a.a.a.fR(9, this.wTC);
            if (this.wTD != null) {
                r0 += e.a.a.b.b.a.h(10, this.wTD);
            }
            return r0 + e.a.a.a.fR(11, this.wEY);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wTA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Receipt");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsg com_tencent_mm_protocal_c_bsg = (bsg) objArr[1];
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
                        com_tencent_mm_protocal_c_bsg.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsg.wTA = fdVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bsg.vIR = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bsg.wTB = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bsg.pbq = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bsg.wEW = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bsg.wEX = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bsg.wEZ = aVar3.Avy.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bsg.wTC = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bsg.wTD = aVar3.Avy.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bsg.wEY = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
