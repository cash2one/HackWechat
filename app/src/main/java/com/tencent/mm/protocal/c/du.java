package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class du extends a {
    public String scope;
    public int state;
    public String vIX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.g(1, this.scope);
            }
            if (this.vIX != null) {
                aVar.g(2, this.vIX);
            }
            aVar.fU(3, this.state);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                r0 = e.a.a.b.b.a.h(1, this.scope) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIX != null) {
                r0 += e.a.a.b.b.a.h(2, this.vIX);
            }
            return r0 + e.a.a.a.fR(3, this.state);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            du duVar = (du) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    duVar.scope = aVar3.Avy.readString();
                    return 0;
                case 2:
                    duVar.vIX = aVar3.Avy.readString();
                    return 0;
                case 3:
                    duVar.state = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
