package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class jn extends a {
    public String fDI;
    public String sNy;
    public String sUr;
    public String title;
    public int type;
    public String url;
    public String vPQ;
    public String vPR;
    public int vPS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.type);
            if (this.sUr != null) {
                aVar.g(2, this.sUr);
            }
            if (this.fDI != null) {
                aVar.g(3, this.fDI);
            }
            if (this.title != null) {
                aVar.g(4, this.title);
            }
            if (this.sNy != null) {
                aVar.g(5, this.sNy);
            }
            if (this.url != null) {
                aVar.g(6, this.url);
            }
            if (this.vPQ != null) {
                aVar.g(7, this.vPQ);
            }
            if (this.vPR != null) {
                aVar.g(8, this.vPR);
            }
            aVar.fU(9, this.vPS);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.type) + 0;
            if (this.sUr != null) {
                r0 += e.a.a.b.b.a.h(2, this.sUr);
            }
            if (this.fDI != null) {
                r0 += e.a.a.b.b.a.h(3, this.fDI);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(4, this.title);
            }
            if (this.sNy != null) {
                r0 += e.a.a.b.b.a.h(5, this.sNy);
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(6, this.url);
            }
            if (this.vPQ != null) {
                r0 += e.a.a.b.b.a.h(7, this.vPQ);
            }
            if (this.vPR != null) {
                r0 += e.a.a.b.b.a.h(8, this.vPR);
            }
            return r0 + e.a.a.a.fR(9, this.vPS);
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
            jn jnVar = (jn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jnVar.type = aVar3.Avy.ry();
                    return 0;
                case 2:
                    jnVar.sUr = aVar3.Avy.readString();
                    return 0;
                case 3:
                    jnVar.fDI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    jnVar.title = aVar3.Avy.readString();
                    return 0;
                case 5:
                    jnVar.sNy = aVar3.Avy.readString();
                    return 0;
                case 6:
                    jnVar.url = aVar3.Avy.readString();
                    return 0;
                case 7:
                    jnVar.vPQ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    jnVar.vPR = aVar3.Avy.readString();
                    return 0;
                case 9:
                    jnVar.vPS = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
