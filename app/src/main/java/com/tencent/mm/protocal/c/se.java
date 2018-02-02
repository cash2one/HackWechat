package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class se extends a {
    public int Height;
    public int Width;
    public String nGE;
    public String wah;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nGE != null) {
                aVar.g(1, this.nGE);
            }
            aVar.fU(2, this.Width);
            aVar.fU(3, this.Height);
            if (this.wah == null) {
                return 0;
            }
            aVar.g(4, this.wah);
            return 0;
        } else if (i == 1) {
            if (this.nGE != null) {
                r0 = e.a.a.b.b.a.h(1, this.nGE) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.Width)) + e.a.a.a.fR(3, this.Height);
            if (this.wah != null) {
                r0 += e.a.a.b.b.a.h(4, this.wah);
            }
            return r0;
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
            se seVar = (se) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    seVar.nGE = aVar3.Avy.readString();
                    return 0;
                case 2:
                    seVar.Width = aVar3.Avy.ry();
                    return 0;
                case 3:
                    seVar.Height = aVar3.Avy.ry();
                    return 0;
                case 4:
                    seVar.wah = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
