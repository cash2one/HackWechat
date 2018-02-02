package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class btm extends bcv {
    public long wFp;
    public int wFq;
    public long wUT;
    public String wUU;
    public long wbi;
    public int whD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.wFq);
            aVar.S(3, this.wUT);
            aVar.S(4, this.wbi);
            if (this.wUU != null) {
                aVar.g(5, this.wUU);
            }
            aVar.S(6, this.wFp);
            aVar.fU(7, this.whD);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.wFq)) + e.a.a.a.R(3, this.wUT)) + e.a.a.a.R(4, this.wbi);
            if (this.wUU != null) {
                r0 += e.a.a.b.b.a.h(5, this.wUU);
            }
            return (r0 + e.a.a.a.R(6, this.wFp)) + e.a.a.a.fR(7, this.whD);
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
            btm com_tencent_mm_protocal_c_btm = (btm) objArr[1];
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
                        com_tencent_mm_protocal_c_btm.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_btm.wFq = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_btm.wUT = aVar3.Avy.rz();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_btm.wbi = aVar3.Avy.rz();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_btm.wUU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_btm.wFp = aVar3.Avy.rz();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_btm.whD = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
