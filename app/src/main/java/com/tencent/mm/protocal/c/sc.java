package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class sc extends a {
    public String nfT;
    public String nfp;
    public String wad;
    public int wae;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfp != null) {
                aVar.g(1, this.nfp);
            }
            if (this.nfT != null) {
                aVar.g(2, this.nfT);
            }
            if (this.wad != null) {
                aVar.g(3, this.wad);
            }
            aVar.fU(4, this.wae);
            return 0;
        } else if (i == 1) {
            if (this.nfp != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfp) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfT != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfT);
            }
            if (this.wad != null) {
                r0 += e.a.a.b.b.a.h(3, this.wad);
            }
            return r0 + e.a.a.a.fR(4, this.wae);
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
            sc scVar = (sc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    scVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 2:
                    scVar.nfT = aVar3.Avy.readString();
                    return 0;
                case 3:
                    scVar.wad = aVar3.Avy.readString();
                    return 0;
                case 4:
                    scVar.wae = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
