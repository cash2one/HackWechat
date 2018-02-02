package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class j extends a {
    public LinkedList<String> ksQ = new LinkedList();
    public LinkedList<Long> ksR = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.ksQ);
            aVar.d(2, 3, this.ksR);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 1, this.ksQ) + 0) + e.a.a.a.c(2, 3, this.ksR);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.ksQ.clear();
                this.ksR.clear();
                e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                j jVar = (j) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        jVar.ksQ.add(aVar3.Avy.readString());
                        return 0;
                    case 2:
                        jVar.ksR.add(Long.valueOf(aVar3.Avy.rz()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
