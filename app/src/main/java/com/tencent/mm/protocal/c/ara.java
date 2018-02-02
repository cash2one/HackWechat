package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ara extends a {
    public int ktN;
    public String nje;
    public int pbl;
    public bdo vGY;
    public String vHc;
    public int wyU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGY == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            if (this.vGY != null) {
                aVar.fW(1, this.vGY.bke());
                this.vGY.a(aVar);
            }
            if (this.nje != null) {
                aVar.g(2, this.nje);
            }
            aVar.fU(3, this.ktN);
            aVar.fU(4, this.pbl);
            aVar.fU(5, this.wyU);
            if (this.vHc == null) {
                return 0;
            }
            aVar.g(6, this.vHc);
            return 0;
        } else if (i == 1) {
            if (this.vGY != null) {
                r0 = e.a.a.a.fT(1, this.vGY.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nje != null) {
                r0 += e.a.a.b.b.a.h(2, this.nje);
            }
            r0 = ((r0 + e.a.a.a.fR(3, this.ktN)) + e.a.a.a.fR(4, this.pbl)) + e.a.a.a.fR(5, this.wyU);
            if (this.vHc != null) {
                r0 += e.a.a.b.b.a.h(6, this.vHc);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
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
            ara com_tencent_mm_protocal_c_ara = (ara) objArr[1];
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
                        com_tencent_mm_protocal_c_ara.vGY = com_tencent_mm_protocal_c_bdo;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ara.nje = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ara.ktN = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ara.pbl = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ara.wyU = aVar3.Avy.ry();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ara.vHc = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
