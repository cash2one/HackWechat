package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bln extends a {
    public int wOD;
    public btg wOE;
    public int wOZ;
    public int wPa;
    public int wPb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wOE == null) {
                throw new b("Not all required fields were included: Addr");
            }
            if (this.wOE != null) {
                aVar.fW(1, this.wOE.bke());
                this.wOE.a(aVar);
            }
            aVar.fU(2, this.wOD);
            aVar.fU(3, this.wOZ);
            aVar.fU(4, this.wPa);
            aVar.fU(5, this.wPb);
            return 0;
        } else if (i == 1) {
            if (this.wOE != null) {
                r0 = e.a.a.a.fT(1, this.wOE.bke()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + e.a.a.a.fR(2, this.wOD)) + e.a.a.a.fR(3, this.wOZ)) + e.a.a.a.fR(4, this.wPa)) + e.a.a.a.fR(5, this.wPb);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wOE != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bln com_tencent_mm_protocal_c_bln = (bln) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_btg = new btg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_btg.a(aVar4, com_tencent_mm_protocal_c_btg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bln.wOE = com_tencent_mm_protocal_c_btg;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bln.wOD = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bln.wOZ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bln.wPa = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bln.wPb = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
