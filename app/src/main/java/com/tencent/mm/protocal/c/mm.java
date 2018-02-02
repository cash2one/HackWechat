package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class mm extends a {
    public String vVg;
    public String vVh;
    public String vVi;
    public int vVj;
    public int vVk;
    public String vVl;
    public int vVm;

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
            aVar.fU(5, this.vVk);
            if (this.vVl != null) {
                aVar.g(6, this.vVl);
            }
            aVar.fU(7, this.vVm);
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
            r0 = (r0 + e.a.a.a.fR(4, this.vVj)) + e.a.a.a.fR(5, this.vVk);
            if (this.vVl != null) {
                r0 += e.a.a.b.b.a.h(6, this.vVl);
            }
            return r0 + e.a.a.a.fR(7, this.vVm);
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
            mm mmVar = (mm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mmVar.vVg = aVar3.Avy.readString();
                    return 0;
                case 2:
                    mmVar.vVh = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mmVar.vVi = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mmVar.vVj = aVar3.Avy.ry();
                    return 0;
                case 5:
                    mmVar.vVk = aVar3.Avy.ry();
                    return 0;
                case 6:
                    mmVar.vVl = aVar3.Avy.readString();
                    return 0;
                case 7:
                    mmVar.vVm = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
