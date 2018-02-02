package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aas extends a {
    public int vHf;
    public bdo wjI;
    public int wjJ;
    public int wjK;
    public int wjL = 1;
    public int wjM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wjI == null) {
                throw new b("Not all required fields were included: ChatroomId");
            }
            if (this.wjI != null) {
                aVar.fW(1, this.wjI.bke());
                this.wjI.a(aVar);
            }
            aVar.fU(2, this.vHf);
            aVar.fU(3, this.wjJ);
            aVar.fU(4, this.wjK);
            aVar.fU(5, this.wjL);
            aVar.fU(6, this.wjM);
            return 0;
        } else if (i == 1) {
            if (this.wjI != null) {
                r0 = e.a.a.a.fT(1, this.wjI.bke()) + 0;
            } else {
                r0 = 0;
            }
            return ((((r0 + e.a.a.a.fR(2, this.vHf)) + e.a.a.a.fR(3, this.wjJ)) + e.a.a.a.fR(4, this.wjK)) + e.a.a.a.fR(5, this.wjL)) + e.a.a.a.fR(6, this.wjM);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wjI != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ChatroomId");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aas com_tencent_mm_protocal_c_aas = (aas) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_bdo = new bdo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bdo.a(aVar4, com_tencent_mm_protocal_c_bdo, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aas.wjI = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aas.vHf = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aas.wjJ = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aas.wjK = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aas.wjL = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aas.wjM = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
