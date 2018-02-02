package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class act extends a {
    public ajr vLz;
    public int wlp;
    public int wlq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLz == null) {
                throw new b("Not all required fields were included: Device");
            }
            aVar.fU(1, this.wlp);
            aVar.fU(2, this.wlq);
            if (this.vLz != null) {
                aVar.fW(3, this.vLz.bke());
                this.vLz.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (e.a.a.a.fR(1, this.wlp) + 0) + e.a.a.a.fR(2, this.wlq);
            if (this.vLz != null) {
                return r0 + e.a.a.a.fT(3, this.vLz.bke());
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vLz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Device");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            act com_tencent_mm_protocal_c_act = (act) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_act.wlp = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_act.wlq = aVar3.Avy.ry();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_ajr = new ajr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_ajr.a(aVar4, com_tencent_mm_protocal_c_ajr, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_act.vLz = com_tencent_mm_protocal_c_ajr;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
