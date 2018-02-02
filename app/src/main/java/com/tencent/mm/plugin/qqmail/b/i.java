package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class i extends a {
    public String nQt;
    public String name;
    public int poA;
    public int poB;
    public String poC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.nQt == null) {
                throw new b("Not all required fields were included: addr");
            } else {
                aVar.fU(1, this.poA);
                if (this.name != null) {
                    aVar.g(2, this.name);
                }
                if (this.nQt != null) {
                    aVar.g(3, this.nQt);
                }
                aVar.fU(4, this.poB);
                if (this.poC != null) {
                    aVar.g(5, this.poC);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.poA) + 0;
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.nQt != null) {
                r0 += e.a.a.b.b.a.h(3, this.nQt);
            }
            r0 += e.a.a.a.fR(4, this.poB);
            if (this.poC != null) {
                return r0 + e.a.a.b.b.a.h(5, this.poC);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.nQt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: addr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.poA = aVar3.Avy.ry();
                    return 0;
                case 2:
                    iVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    iVar.nQt = aVar3.Avy.readString();
                    return 0;
                case 4:
                    iVar.poB = aVar3.Avy.ry();
                    return 0;
                case 5:
                    iVar.poC = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
