package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class apz extends a {
    public String lOo;
    public int rYW;
    public int wwH;
    public aoh wwI;
    public int wwJ;
    public long wwK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.rYW);
            aVar.fU(2, this.wwH);
            if (this.wwI != null) {
                aVar.fW(3, this.wwI.bke());
                this.wwI.a(aVar);
            }
            aVar.fU(4, this.wwJ);
            if (this.lOo != null) {
                aVar.g(5, this.lOo);
            }
            aVar.S(6, this.wwK);
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.rYW) + 0) + e.a.a.a.fR(2, this.wwH);
            if (this.wwI != null) {
                r0 += e.a.a.a.fT(3, this.wwI.bke());
            }
            r0 += e.a.a.a.fR(4, this.wwJ);
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(5, this.lOo);
            }
            return r0 + e.a.a.a.R(6, this.wwK);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apz com_tencent_mm_protocal_c_apz = (apz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_apz.rYW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apz.wwH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_aoh = new aoh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apz.wwI = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_apz.wwJ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_apz.lOo = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_apz.wwK = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
