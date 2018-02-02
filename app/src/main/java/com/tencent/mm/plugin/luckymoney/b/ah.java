package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bq.a;

public final class ah extends a {
    public String content;
    public int gEx;
    public String iconUrl;
    public String name;
    public int odF;
    public int odG;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.gEx);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.type != null) {
                aVar.g(3, this.type);
            }
            if (this.content != null) {
                aVar.g(4, this.content);
            }
            aVar.fU(5, this.odF);
            if (this.iconUrl != null) {
                aVar.g(6, this.iconUrl);
            }
            aVar.fU(7, this.odG);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.gEx) + 0;
            if (this.name != null) {
                r0 += e.a.a.b.b.a.h(2, this.name);
            }
            if (this.type != null) {
                r0 += e.a.a.b.b.a.h(3, this.type);
            }
            if (this.content != null) {
                r0 += e.a.a.b.b.a.h(4, this.content);
            }
            r0 += e.a.a.a.fR(5, this.odF);
            if (this.iconUrl != null) {
                r0 += e.a.a.b.b.a.h(6, this.iconUrl);
            }
            return r0 + e.a.a.a.fR(7, this.odG);
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
            ah ahVar = (ah) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahVar.gEx = aVar3.Avy.ry();
                    return 0;
                case 2:
                    ahVar.name = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ahVar.type = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ahVar.content = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ahVar.odF = aVar3.Avy.ry();
                    return 0;
                case 6:
                    ahVar.iconUrl = aVar3.Avy.readString();
                    return 0;
                case 7:
                    ahVar.odG = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
