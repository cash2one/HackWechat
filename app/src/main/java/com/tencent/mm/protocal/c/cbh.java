package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class cbh extends a {
    public b vNh;
    public LinkedList<cbe> vNi = new LinkedList();
    public String xaw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xaw == null) {
                throw new e.a.a.b("Not all required fields were included: WxaUserName");
            }
            if (this.xaw != null) {
                aVar.g(1, this.xaw);
            }
            if (this.vNh != null) {
                aVar.b(2, this.vNh);
            }
            aVar.d(3, 8, this.vNi);
            return 0;
        } else if (i == 1) {
            if (this.xaw != null) {
                r0 = e.a.a.b.b.a.h(1, this.xaw) + 0;
            } else {
                r0 = 0;
            }
            if (this.vNh != null) {
                r0 += e.a.a.a.a(2, this.vNh);
            }
            return r0 + e.a.a.a.c(3, 8, this.vNi);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vNi.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.xaw != null) {
                return 0;
            }
            throw new e.a.a.b("Not all required fields were included: WxaUserName");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbh com_tencent_mm_protocal_c_cbh = (cbh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_cbh.xaw = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_cbh.vNh = aVar3.cJD();
                    return 0;
                case 3:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_cbe = new cbe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_cbe.a(aVar4, com_tencent_mm_protocal_c_cbe, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_cbh.vNi.add(com_tencent_mm_protocal_c_cbe);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
