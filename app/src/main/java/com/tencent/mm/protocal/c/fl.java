package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class fl extends a {
    public int vLg;
    public int vLh;
    public LinkedList<String> vLi = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vLg);
            aVar.fU(2, this.vLh);
            aVar.d(3, 1, this.vLi);
            return 0;
        } else if (i == 1) {
            return ((e.a.a.a.fR(1, this.vLg) + 0) + e.a.a.a.fR(2, this.vLh)) + e.a.a.a.c(3, 1, this.vLi);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.vLi.clear();
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
                fl flVar = (fl) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        flVar.vLg = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        flVar.vLh = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        flVar.vLi.add(aVar3.Avy.readString());
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
