package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class ou extends a {
    public String fpx;
    public String fpy;
    public int vXD;
    public int vXE;
    public String vXF;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.version);
            aVar.fU(2, this.vXD);
            aVar.fU(3, this.vXE);
            if (this.fpy != null) {
                aVar.g(4, this.fpy);
            }
            if (this.vXF != null) {
                aVar.g(5, this.vXF);
            }
            if (this.fpx != null) {
                aVar.g(6, this.fpx);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.version) + 0) + e.a.a.a.fR(2, this.vXD)) + e.a.a.a.fR(3, this.vXE);
            if (this.fpy != null) {
                r0 += e.a.a.b.b.a.h(4, this.fpy);
            }
            if (this.vXF != null) {
                r0 += e.a.a.b.b.a.h(5, this.vXF);
            }
            if (this.fpx != null) {
                return r0 + e.a.a.b.b.a.h(6, this.fpx);
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
            ou ouVar = (ou) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ouVar.version = aVar3.Avy.ry();
                    return 0;
                case 2:
                    ouVar.vXD = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ouVar.vXE = aVar3.Avy.ry();
                    return 0;
                case 4:
                    ouVar.fpy = aVar3.Avy.readString();
                    return 0;
                case 5:
                    ouVar.vXF = aVar3.Avy.readString();
                    return 0;
                case 6:
                    ouVar.fpx = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
