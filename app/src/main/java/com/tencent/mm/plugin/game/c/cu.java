package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class cu extends a {
    public String nfp;
    public String njt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.njt == null) {
                throw new b("Not all required fields were included: Color");
            } else {
                if (this.nfp != null) {
                    aVar.g(1, this.nfp);
                }
                if (this.njt == null) {
                    return 0;
                }
                aVar.g(2, this.njt);
                return 0;
            }
        } else if (i == 1) {
            if (this.nfp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfp) + 0;
            } else {
                r0 = 0;
            }
            if (this.njt != null) {
                r0 += e.a.a.b.b.a.h(2, this.njt);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfp == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.njt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Color");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cu cuVar = (cu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    cuVar.njt = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
