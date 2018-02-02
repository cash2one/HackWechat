package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class mf extends a {
    public String ksU;
    public String kub;
    public String vUT;
    public String vUU;
    public String vUV;
    public int vUW;
    public String vUX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            if (this.vUT != null) {
                aVar.g(3, this.vUT);
            }
            if (this.vUU != null) {
                aVar.g(4, this.vUU);
            }
            if (this.vUV != null) {
                aVar.g(5, this.vUV);
            }
            aVar.fU(6, this.vUW);
            if (this.vUX == null) {
                return 0;
            }
            aVar.g(7, this.vUX);
            return 0;
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            if (this.vUT != null) {
                r0 += e.a.a.b.b.a.h(3, this.vUT);
            }
            if (this.vUU != null) {
                r0 += e.a.a.b.b.a.h(4, this.vUU);
            }
            if (this.vUV != null) {
                r0 += e.a.a.b.b.a.h(5, this.vUV);
            }
            r0 += e.a.a.a.fR(6, this.vUW);
            if (this.vUX != null) {
                r0 += e.a.a.b.b.a.h(7, this.vUX);
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
            mf mfVar = (mf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mfVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    mfVar.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mfVar.vUT = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mfVar.vUU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mfVar.vUV = aVar3.Avy.readString();
                    return 0;
                case 6:
                    mfVar.vUW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    mfVar.vUX = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
