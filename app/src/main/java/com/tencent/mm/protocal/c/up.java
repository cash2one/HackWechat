package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class up extends a {
    public int ktm;
    public String vQA;
    public int vQB;
    public String vVg;
    public String vVh;
    public String vVi;
    public int vVj;
    public String wcA;
    public int wcB;
    public String wcz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vVg != null) {
                aVar.g(1, this.vVg);
            }
            if (this.vVh != null) {
                aVar.g(2, this.vVh);
            }
            if (this.vVi != null) {
                aVar.g(3, this.vVi);
            }
            aVar.fU(4, this.vVj);
            if (this.wcz != null) {
                aVar.g(5, this.wcz);
            }
            if (this.vQA != null) {
                aVar.g(6, this.vQA);
            }
            aVar.fU(7, this.vQB);
            if (this.wcA != null) {
                aVar.g(8, this.wcA);
            }
            aVar.fU(9, this.ktm);
            aVar.fU(10, this.wcB);
            return 0;
        } else if (i == 1) {
            if (this.vVg != null) {
                r0 = e.a.a.b.b.a.h(1, this.vVg) + 0;
            } else {
                r0 = 0;
            }
            if (this.vVh != null) {
                r0 += e.a.a.b.b.a.h(2, this.vVh);
            }
            if (this.vVi != null) {
                r0 += e.a.a.b.b.a.h(3, this.vVi);
            }
            r0 += e.a.a.a.fR(4, this.vVj);
            if (this.wcz != null) {
                r0 += e.a.a.b.b.a.h(5, this.wcz);
            }
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(6, this.vQA);
            }
            r0 += e.a.a.a.fR(7, this.vQB);
            if (this.wcA != null) {
                r0 += e.a.a.b.b.a.h(8, this.wcA);
            }
            return (r0 + e.a.a.a.fR(9, this.ktm)) + e.a.a.a.fR(10, this.wcB);
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
            up upVar = (up) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    upVar.vVg = aVar3.Avy.readString();
                    return 0;
                case 2:
                    upVar.vVh = aVar3.Avy.readString();
                    return 0;
                case 3:
                    upVar.vVi = aVar3.Avy.readString();
                    return 0;
                case 4:
                    upVar.vVj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    upVar.wcz = aVar3.Avy.readString();
                    return 0;
                case 6:
                    upVar.vQA = aVar3.Avy.readString();
                    return 0;
                case 7:
                    upVar.vQB = aVar3.Avy.ry();
                    return 0;
                case 8:
                    upVar.wcA = aVar3.Avy.readString();
                    return 0;
                case 9:
                    upVar.ktm = aVar3.Avy.ry();
                    return 0;
                case 10:
                    upVar.wcB = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
