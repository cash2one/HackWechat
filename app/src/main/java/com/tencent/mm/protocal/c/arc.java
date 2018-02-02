package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class arc extends a {
    public String opJ;
    public LinkedList<String> wyW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.opJ != null) {
                aVar.g(1, this.opJ);
            }
            aVar.d(2, 1, this.wyW);
            return 0;
        } else if (i == 1) {
            if (this.opJ != null) {
                r0 = e.a.a.b.b.a.h(1, this.opJ) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 1, this.wyW);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wyW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
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
            arc com_tencent_mm_protocal_c_arc = (arc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_arc.opJ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arc.wyW.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
