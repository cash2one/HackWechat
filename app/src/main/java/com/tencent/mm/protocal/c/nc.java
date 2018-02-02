package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class nc extends a {
    public b vVV;
    public LinkedList<b> vVW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vVV != null) {
                aVar.b(1, this.vVV);
            }
            aVar.d(2, 6, this.vVW);
            return 0;
        } else if (i == 1) {
            if (this.vVV != null) {
                r0 = e.a.a.a.a(1, this.vVV) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 6, this.vVW);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vVW.clear();
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
            nc ncVar = (nc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ncVar.vVV = aVar3.cJD();
                    return 0;
                case 2:
                    ncVar.vVW.add(aVar3.cJD());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
