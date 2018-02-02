package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class awk extends bcv {
    public int vDY;
    public int vQL;
    public au vQS;
    public String wEb;
    public String wEc;
    public b wEd;
    public int wEe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.wEb != null) {
                aVar.g(2, this.wEb);
            }
            if (this.wEc != null) {
                aVar.g(3, this.wEc);
            }
            if (this.wEd != null) {
                aVar.b(4, this.wEd);
            }
            aVar.fU(5, this.vQL);
            aVar.fU(6, this.vDY);
            aVar.fU(7, this.wEe);
            if (this.vQS == null) {
                return 0;
            }
            aVar.fW(8, this.vQS.bke());
            this.vQS.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.wEb != null) {
                r0 += e.a.a.b.b.a.h(2, this.wEb);
            }
            if (this.wEc != null) {
                r0 += e.a.a.b.b.a.h(3, this.wEc);
            }
            if (this.wEd != null) {
                r0 += e.a.a.a.a(4, this.wEd);
            }
            r0 = ((r0 + e.a.a.a.fR(5, this.vQL)) + e.a.a.a.fR(6, this.vDY)) + e.a.a.a.fR(7, this.wEe);
            if (this.vQS != null) {
                r0 += e.a.a.a.fT(8, this.vQS.bke());
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
            awk com_tencent_mm_protocal_c_awk = (awk) objArr[1];
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
                        com_tencent_mm_protocal_c_awk.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awk.wEb = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awk.wEc = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awk.wEd = aVar3.cJD();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awk.vQL = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awk.vDY = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awk.wEe = aVar3.Avy.ry();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new au();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awk.vQS = fdVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
