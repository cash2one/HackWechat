package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bua extends bcv {
    public String nko;
    public String wFM;
    public int wFq;
    public long wUq;
    public bvb wVk;
    public int wVl;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wVk == null) {
                throw new b("Not all required fields were included: ReportData");
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
            if (this.nko != null) {
                aVar.g(6, this.nko);
            }
            if (this.wVk != null) {
                aVar.fW(8, this.wVk.bke());
                this.wVk.a(aVar);
            }
            aVar.fU(9, this.wVl);
            aVar.S(10, this.wUq);
            aVar.fU(11, this.wFq);
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
            r0 = (r0 + e.a.a.a.fR(3, this.wbh)) + e.a.a.a.R(4, this.wbi);
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(6, this.nko);
            }
            if (this.wVk != null) {
                r0 += e.a.a.a.fT(8, this.wVk.bke());
            }
            return ((r0 + e.a.a.a.fR(9, this.wVl)) + e.a.a.a.R(10, this.wUq)) + e.a.a.a.fR(11, this.wFq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wVk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReportData");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bua com_tencent_mm_protocal_c_bua = (bua) objArr[1];
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
                        com_tencent_mm_protocal_c_bua.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bua.wFM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bua.wbh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bua.wbi = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bua.nko = aVar3.Avy.readString();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bvb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bua.wVk = fdVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bua.wVl = aVar3.Avy.ry();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bua.wUq = aVar3.Avy.rz();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bua.wFq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
