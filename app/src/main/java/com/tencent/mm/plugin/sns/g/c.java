package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class c extends a {
    public LinkedList<Long> raI = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).d(1, 3, this.raI);
            return 0;
        } else if (i == 1) {
            return e.a.a.a.c(1, 3, this.raI) + 0;
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.raI.clear();
                e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.raI.add(Long.valueOf(aVar2.Avy.rz()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
