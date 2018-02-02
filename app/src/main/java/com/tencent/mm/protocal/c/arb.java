package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class arb extends bdf {
    public int ktN;
    public int pbl;
    public int vGW;
    public bdo vGY;
    public long vHe;
    public int vJU;
    public int wyU;
    public int wyV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            aVar.fU(1, this.vJU);
            if (this.vGY != null) {
                aVar.fW(2, this.vGY.bke());
                this.vGY.a(aVar);
            }
            aVar.fU(3, this.vGW);
            aVar.fU(4, this.wyU);
            aVar.fU(5, this.pbl);
            aVar.fU(6, this.wyV);
            aVar.fU(7, this.ktN);
            aVar.S(8, this.vHe);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vJU) + 0;
            if (this.vGY != null) {
                r0 += e.a.a.a.fT(2, this.vGY.bke());
            }
            return (((((r0 + e.a.a.a.fR(3, this.vGW)) + e.a.a.a.fR(4, this.wyU)) + e.a.a.a.fR(5, this.pbl)) + e.a.a.a.fR(6, this.wyV)) + e.a.a.a.fR(7, this.ktN)) + e.a.a.a.R(8, this.vHe);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vGY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ToUserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arb com_tencent_mm_protocal_c_arb = (arb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_arb.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bdo = new bdo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, bdf.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arb.vGY = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arb.vGW = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arb.wyU = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_arb.pbl = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_arb.wyV = aVar3.Avy.ry();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_arb.ktN = aVar3.Avy.ry();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_arb.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
