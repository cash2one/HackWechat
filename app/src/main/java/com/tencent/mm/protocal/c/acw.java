package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class acw extends a {
    public int vJU;
    public ajr vLz;
    public String vZK;
    public int wlp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vJU);
            if (this.vLz != null) {
                aVar.fW(2, this.vLz.bke());
                this.vLz.a(aVar);
            }
            if (this.vZK != null) {
                aVar.g(3, this.vZK);
            }
            aVar.fU(4, this.wlp);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vJU) + 0;
            if (this.vLz != null) {
                r0 += e.a.a.a.fT(2, this.vLz.bke());
            }
            if (this.vZK != null) {
                r0 += e.a.a.b.b.a.h(3, this.vZK);
            }
            return r0 + e.a.a.a.fR(4, this.wlp);
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
            acw com_tencent_mm_protocal_c_acw = (acw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_acw.vJU = aVar3.Avy.ry();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_ajr = new ajr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_ajr.a(aVar4, com_tencent_mm_protocal_c_ajr, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acw.vLz = com_tencent_mm_protocal_c_ajr;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_acw.vZK = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_acw.wlp = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
