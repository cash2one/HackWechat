package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class amo extends bcv {
    public b ksB;
    public String ngo;
    public int wtb;
    public int wtc;
    public cbj wtd;
    public String wtk;

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
            if (this.ksB != null) {
                aVar.b(3, this.ksB);
            }
            if (this.wtk != null) {
                aVar.g(4, this.wtk);
            }
            aVar.fU(5, this.wtb);
            aVar.fU(6, this.wtc);
            if (this.wtd == null) {
                return 0;
            }
            aVar.fW(7, this.wtd.bke());
            this.wtd.a(aVar);
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
            if (this.ksB != null) {
                r0 += e.a.a.a.a(3, this.ksB);
            }
            if (this.wtk != null) {
                r0 += e.a.a.b.b.a.h(4, this.wtk);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.wtb)) + e.a.a.a.fR(6, this.wtc);
            if (this.wtd != null) {
                r0 += e.a.a.a.fT(7, this.wtd.bke());
            }
            return r0;
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
            amo com_tencent_mm_protocal_c_amo = (amo) objArr[1];
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
                        com_tencent_mm_protocal_c_amo.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amo.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amo.ksB = aVar3.cJD();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amo.wtk = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_amo.wtb = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_amo.wtc = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new cbj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amo.wtd = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
