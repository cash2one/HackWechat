package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class bte extends bcv {
    public int vWK;
    public String wFM;
    public int wUl;
    public but wUm;
    public but wUn;
    public String wUo;
    public int wUp;
    public long wUq;
    public int wbh;
    public long wbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wbh);
            aVar.S(3, this.wbi);
            if (this.wFM != null) {
                aVar.g(4, this.wFM);
            }
            aVar.fU(5, this.wUl);
            if (this.wUm != null) {
                aVar.fW(6, this.wUm.bke());
                this.wUm.a(aVar);
            }
            if (this.wUn != null) {
                aVar.fW(7, this.wUn.bke());
                this.wUn.a(aVar);
            }
            aVar.fU(8, this.vWK);
            if (this.wUo != null) {
                aVar.g(9, this.wUo);
            }
            aVar.fU(10, this.wUp);
            aVar.S(11, this.wUq);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.R(3, this.wbi);
            if (this.wFM != null) {
                r0 += e.a.a.b.b.a.h(4, this.wFM);
            }
            r0 += e.a.a.a.fR(5, this.wUl);
            if (this.wUm != null) {
                r0 += e.a.a.a.fT(6, this.wUm.bke());
            }
            if (this.wUn != null) {
                r0 += e.a.a.a.fT(7, this.wUn.bke());
            }
            r0 += e.a.a.a.fR(8, this.vWK);
            if (this.wUo != null) {
                r0 += e.a.a.b.b.a.h(9, this.wUo);
            }
            return (r0 + e.a.a.a.fR(10, this.wUp)) + e.a.a.a.R(11, this.wUq);
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
            bte com_tencent_mm_protocal_c_bte = (bte) objArr[1];
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
                        com_tencent_mm_protocal_c_bte.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bte.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bte.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bte.wFM = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bte.wUl = aVar3.Avy.ry();
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
                        com_tencent_mm_protocal_c_bte.wUm = fdVar;
                    }
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new but();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bte.wUn = fdVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bte.vWK = aVar3.Avy.ry();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bte.wUo = aVar3.Avy.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bte.wUp = aVar3.Avy.ry();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bte.wUq = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
