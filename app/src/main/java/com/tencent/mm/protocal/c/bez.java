package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class bez extends a {
    public String lOo;
    public int rYW;
    public String wKh;
    public aoh wwI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wKh != null) {
                aVar.g(1, this.wKh);
            }
            aVar.fU(2, this.rYW);
            if (this.lOo != null) {
                aVar.g(3, this.lOo);
            }
            if (this.wwI == null) {
                return 0;
            }
            aVar.fW(4, this.wwI.bke());
            this.wwI.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.wKh != null) {
                r0 = e.a.a.b.b.a.h(1, this.wKh) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.rYW);
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(3, this.lOo);
            }
            if (this.wwI != null) {
                r0 += e.a.a.a.fT(4, this.wwI.bke());
            }
            return r0;
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
            bez com_tencent_mm_protocal_c_bez = (bez) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bez.wKh = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bez.rYW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bez.lOo = aVar3.Avy.readString();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_aoh = new aoh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aoh.a(aVar4, com_tencent_mm_protocal_c_aoh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bez.wwI = com_tencent_mm_protocal_c_aoh;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
