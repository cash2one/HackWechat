package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class jg extends a {
    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                if (!super.a(aVar, this, a)) {
                    aVar.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            ((Integer) objArr[2]).intValue();
            return -1;
        }
    }
}
