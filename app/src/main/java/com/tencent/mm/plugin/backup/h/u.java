package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;

public final class u extends a {
    public String gjM;
    public int ktI;
    public int ktJ;
    public long ktK;
    public String mediaId;
    public String path;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.ktI);
            if (this.gjM != null) {
                aVar.g(2, this.gjM);
            }
            if (this.mediaId != null) {
                aVar.g(3, this.mediaId);
            }
            if (this.path != null) {
                aVar.g(4, this.path);
            }
            aVar.fU(5, this.type);
            aVar.fU(6, this.ktJ);
            aVar.S(7, this.ktK);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktI) + 0;
            if (this.gjM != null) {
                r0 += e.a.a.b.b.a.h(2, this.gjM);
            }
            if (this.mediaId != null) {
                r0 += e.a.a.b.b.a.h(3, this.mediaId);
            }
            if (this.path != null) {
                r0 += e.a.a.b.b.a.h(4, this.path);
            }
            return ((r0 + e.a.a.a.fR(5, this.type)) + e.a.a.a.fR(6, this.ktJ)) + e.a.a.a.R(7, this.ktK);
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
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.ktI = aVar3.Avy.ry();
                    return 0;
                case 2:
                    uVar.gjM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    uVar.mediaId = aVar3.Avy.readString();
                    return 0;
                case 4:
                    uVar.path = aVar3.Avy.readString();
                    return 0;
                case 5:
                    uVar.type = aVar3.Avy.ry();
                    return 0;
                case 6:
                    uVar.ktJ = aVar3.Avy.ry();
                    return 0;
                case 7:
                    uVar.ktK = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
