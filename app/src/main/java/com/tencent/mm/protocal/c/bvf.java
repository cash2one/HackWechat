package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvf extends bcv {
    public bdn vRA;
    public int vRz;
    public String wFM;
    public long wUq;
    public bud wWH;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vRA == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.wWH == null) {
                throw new b("Not all required fields were included: OpLog");
            } else {
                if (this.wIV != null) {
                    aVar.fW(1, this.wIV.bke());
                    this.wIV.a(aVar);
                }
                if (this.wFM != null) {
                    aVar.g(2, this.wFM);
                }
                aVar.fU(3, this.wbh);
                if (this.vRA != null) {
                    aVar.fW(4, this.vRA.bke());
                    this.vRA.a(aVar);
                }
                if (this.wWH != null) {
                    aVar.fW(5, this.wWH.bke());
                    this.wWH.a(aVar);
                }
                aVar.S(6, this.wbi);
                aVar.fU(7, this.vRz);
                aVar.S(8, this.wUq);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wFM != null) {
                r0 += e.a.a.b.b.a.h(2, this.wFM);
            }
            r0 += e.a.a.a.fR(3, this.wbh);
            if (this.vRA != null) {
                r0 += e.a.a.a.fT(4, this.vRA.bke());
            }
            if (this.wWH != null) {
                r0 += e.a.a.a.fT(5, this.wWH.bke());
            }
            return ((r0 + e.a.a.a.R(6, this.wbi)) + e.a.a.a.fR(7, this.vRz)) + e.a.a.a.R(8, this.wUq);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vRA == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.wWH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: OpLog");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvf com_tencent_mm_protocal_c_bvf = (bvf) objArr[1];
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
                        com_tencent_mm_protocal_c_bvf.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bvf.wFM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bvf.wbh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bvf.vRA = fdVar;
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bud();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bvf.wWH = fdVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bvf.wbi = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bvf.vRz = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bvf.wUq = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
