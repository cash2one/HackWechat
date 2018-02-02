package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class anz extends bcv {
    public String ngo;
    public int wnA;
    public cam wuO;
    public cbm wuP;
    public cbi wuQ;
    public cbs wuR;
    public cbl wuS;
    public cbn wuT;
    public int wuU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            if (this.wuO != null) {
                aVar.fW(3, this.wuO.bke());
                this.wuO.a(aVar);
            }
            aVar.fU(4, this.wnA);
            if (this.wuP != null) {
                aVar.fW(5, this.wuP.bke());
                this.wuP.a(aVar);
            }
            if (this.wuQ != null) {
                aVar.fW(6, this.wuQ.bke());
                this.wuQ.a(aVar);
            }
            if (this.wuR != null) {
                aVar.fW(7, this.wuR.bke());
                this.wuR.a(aVar);
            }
            if (this.wuS != null) {
                aVar.fW(8, this.wuS.bke());
                this.wuS.a(aVar);
            }
            if (this.wuT != null) {
                aVar.fW(9, this.wuT.bke());
                this.wuT.a(aVar);
            }
            aVar.fU(10, this.wuU);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.wuO != null) {
                r0 += e.a.a.a.fT(3, this.wuO.bke());
            }
            r0 += e.a.a.a.fR(4, this.wnA);
            if (this.wuP != null) {
                r0 += e.a.a.a.fT(5, this.wuP.bke());
            }
            if (this.wuQ != null) {
                r0 += e.a.a.a.fT(6, this.wuQ.bke());
            }
            if (this.wuR != null) {
                r0 += e.a.a.a.fT(7, this.wuR.bke());
            }
            if (this.wuS != null) {
                r0 += e.a.a.a.fT(8, this.wuS.bke());
            }
            if (this.wuT != null) {
                r0 += e.a.a.a.fT(9, this.wuT.bke());
            }
            return r0 + e.a.a.a.fR(10, this.wuU);
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
            anz com_tencent_mm_protocal_c_anz = (anz) objArr[1];
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
                        com_tencent_mm_protocal_c_anz.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anz.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cam();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anz.wuO = fdVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anz.wnA = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cbm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anz.wuP = fdVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cbi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anz.wuQ = fdVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cbs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anz.wuR = fdVar;
                    }
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cbl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anz.wuS = fdVar;
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cbn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anz.wuT = fdVar;
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_anz.wuU = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
