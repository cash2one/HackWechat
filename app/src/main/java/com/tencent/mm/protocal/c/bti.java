package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bti extends bcv {
    public int vWK;
    public String wFM;
    public int wUA;
    public but wUm;
    public but wUn;
    public long wUq;
    public int wUz;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wFM != null) {
                aVar.g(2, this.wFM);
            }
            aVar.fU(3, this.wbh);
            aVar.fU(4, this.wUz);
            if (this.wUm != null) {
                aVar.fW(5, this.wUm.bke());
                this.wUm.a(aVar);
            }
            if (this.wUn != null) {
                aVar.fW(6, this.wUn.bke());
                this.wUn.a(aVar);
            }
            aVar.S(7, this.wbi);
            aVar.fU(8, this.vWK);
            aVar.S(9, this.wUq);
            aVar.fU(10, this.wUA);
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
            r0 = (r0 + e.a.a.a.fR(3, this.wbh)) + e.a.a.a.fR(4, this.wUz);
            if (this.wUm != null) {
                r0 += e.a.a.a.fT(5, this.wUm.bke());
            }
            if (this.wUn != null) {
                r0 += e.a.a.a.fT(6, this.wUn.bke());
            }
            return (((r0 + e.a.a.a.R(7, this.wbi)) + e.a.a.a.fR(8, this.vWK)) + e.a.a.a.R(9, this.wUq)) + e.a.a.a.fR(10, this.wUA);
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
            bti com_tencent_mm_protocal_c_bti = (bti) objArr[1];
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
                        com_tencent_mm_protocal_c_bti.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bti.wFM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bti.wbh = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bti.wUz = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new but();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bti.wUm = fdVar;
                    }
                    return 0;
                case 6:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new but();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bti.wUn = fdVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bti.wbi = aVar3.Avy.rz();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bti.vWK = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bti.wUq = aVar3.Avy.rz();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bti.wUA = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
