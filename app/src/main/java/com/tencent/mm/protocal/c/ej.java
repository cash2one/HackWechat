package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ej extends a {
    public LinkedList<String> vJK = new LinkedList();
    public int vJL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.vJK);
            aVar.fU(2, this.vJL);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.c(1, 1, this.vJK) + 0) + e.a.a.a.fR(2, this.vJL);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.vJK.clear();
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
                ej ejVar = (ej) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        ejVar.vJK.add(aVar3.Avy.readString());
                        return 0;
                    case 2:
                        ejVar.vJL = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
