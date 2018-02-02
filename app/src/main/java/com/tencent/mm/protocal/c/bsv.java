package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsv extends bcv {
    public String ksU;
    public int vIE;
    public int vIH;
    public int vLj;
    public int vNW;
    public bdn vXz;
    public String wRR;
    public int wRS;
    public int wRT;
    public int wTV;
    public int wTW;
    public LinkedList<bdo> wTX = new LinkedList();
    public LinkedList<bdn> wTY = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vXz == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ksU != null) {
                aVar.g(2, this.ksU);
            }
            if (this.vXz != null) {
                aVar.fW(3, this.vXz.bke());
                this.vXz.a(aVar);
            }
            aVar.fU(4, this.vNW);
            if (this.wRR != null) {
                aVar.g(5, this.wRR);
            }
            aVar.fU(6, this.vLj);
            aVar.fU(7, this.wRS);
            aVar.fU(8, this.vIH);
            aVar.fU(9, this.wRT);
            aVar.fU(10, this.vIE);
            aVar.fU(11, this.wTV);
            aVar.fU(12, this.wTW);
            aVar.d(13, 8, this.wTX);
            aVar.d(14, 8, this.wTY);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            if (this.vXz != null) {
                r0 += e.a.a.a.fT(3, this.vXz.bke());
            }
            r0 += e.a.a.a.fR(4, this.vNW);
            if (this.wRR != null) {
                r0 += e.a.a.b.b.a.h(5, this.wRR);
            }
            return ((((((((r0 + e.a.a.a.fR(6, this.vLj)) + e.a.a.a.fR(7, this.wRS)) + e.a.a.a.fR(8, this.vIH)) + e.a.a.a.fR(9, this.wRT)) + e.a.a.a.fR(10, this.vIE)) + e.a.a.a.fR(11, this.wTV)) + e.a.a.a.fR(12, this.wTW)) + e.a.a.a.c(13, 8, this.wTX)) + e.a.a.a.c(14, 8, this.wTY);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.wTX.clear();
            this.wTY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsv com_tencent_mm_protocal_c_bsv = (bsv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsv.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bsv.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsv.vXz = fdVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bsv.vNW = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bsv.wRR = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bsv.vLj = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bsv.wRS = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bsv.vIH = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bsv.wRT = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bsv.vIE = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bsv.wTV = aVar3.Avy.ry();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bsv.wTW = aVar3.Avy.ry();
                    return 0;
                case 13:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsv.wTX.add(fdVar);
                    }
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bsv.wTY.add(fdVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
