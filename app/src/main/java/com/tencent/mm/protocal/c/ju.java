package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ju extends a {
    public String vQJ;
    public LinkedList<String> vQK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQJ != null) {
                aVar.g(1, this.vQJ);
            }
            aVar.d(2, 1, this.vQK);
            return 0;
        } else if (i == 1) {
            if (this.vQJ != null) {
                r0 = e.a.a.b.b.a.h(1, this.vQJ) + 0;
            } else {
                r0 = 0;
            }
            return r0 + e.a.a.a.c(2, 1, this.vQK);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vQK.clear();
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
            ju juVar = (ju) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    juVar.vQJ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    juVar.vQK.add(aVar3.Avy.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
