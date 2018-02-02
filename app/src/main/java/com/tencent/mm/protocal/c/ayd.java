package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ayd extends bcv {
    public String nko;
    public long wFp;
    public int wFq;
    public String wFr;
    public long wFs;
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
            if (this.nko != null) {
                aVar.g(4, this.nko);
            }
            aVar.S(5, this.wFp);
            aVar.fU(6, this.wFq);
            if (this.wFr != null) {
                aVar.g(7, this.wFr);
            }
            aVar.S(8, this.wFs);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.wbh)) + e.a.a.a.R(3, this.wbi);
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(4, this.nko);
            }
            r0 = (r0 + e.a.a.a.R(5, this.wFp)) + e.a.a.a.fR(6, this.wFq);
            if (this.wFr != null) {
                r0 += e.a.a.b.b.a.h(7, this.wFr);
            }
            return r0 + e.a.a.a.R(8, this.wFs);
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
            ayd com_tencent_mm_protocal_c_ayd = (ayd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ayd.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayd.wbh = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayd.wbi = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ayd.nko = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ayd.wFp = aVar3.Avy.rz();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayd.wFq = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ayd.wFr = aVar3.Avy.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ayd.wFs = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
