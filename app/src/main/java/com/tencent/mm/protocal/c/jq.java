package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class jq extends a {
    public int vQn;
    public LinkedList<Integer> vQo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vQn);
            aVar.c(2, this.vQo);
            return 0;
        } else if (i == 1) {
            return (e.a.a.a.fR(1, this.vQn) + 0) + e.a.a.a.b(2, this.vQo);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.vQo.clear();
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
                jq jqVar = (jq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        jqVar.vQn = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        jqVar.vQo = new e.a.a.a.a(aVar3.cJD().oz, unknownTagHandler).cJA();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
