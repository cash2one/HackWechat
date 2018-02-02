package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class jf extends a {
    public String nfT;
    public String vPt;
    public String vPu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfT == null) {
                throw new b("Not all required fields were included: IconUrl");
            }
            if (this.nfT != null) {
                aVar.g(1, this.nfT);
            }
            if (this.vPt != null) {
                aVar.g(2, this.vPt);
            }
            if (this.vPu == null) {
                return 0;
            }
            aVar.g(3, this.vPu);
            return 0;
        } else if (i == 1) {
            if (this.nfT != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfT) + 0;
            } else {
                r0 = 0;
            }
            if (this.vPt != null) {
                r0 += e.a.a.b.b.a.h(2, this.vPt);
            }
            if (this.vPu != null) {
                r0 += e.a.a.b.b.a.h(3, this.vPu);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: IconUrl");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jf jfVar = (jf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jfVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 2:
                    jfVar.vPt = aVar3.Avy.readString();
                    return 0;
                case 3:
                    jfVar.vPu = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
