package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class wv extends a {
    public int bZN;
    public String fon;
    public String nfe;
    public String ngo;
    public String niZ;
    public String pbP;
    public String wgR;
    public int whm;
    public int whn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfe == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.pbP == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                if (this.fon != null) {
                    aVar.g(1, this.fon);
                }
                if (this.nfe != null) {
                    aVar.g(2, this.nfe);
                }
                if (this.pbP != null) {
                    aVar.g(3, this.pbP);
                }
                if (this.wgR != null) {
                    aVar.g(4, this.wgR);
                }
                aVar.fU(5, this.whm);
                aVar.fU(6, this.whn);
                if (this.ngo != null) {
                    aVar.g(7, this.ngo);
                }
                aVar.fU(8, this.bZN);
                if (this.niZ == null) {
                    return 0;
                }
                aVar.g(9, this.niZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.fon != null) {
                r0 = e.a.a.b.b.a.h(1, this.fon) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfe != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfe);
            }
            if (this.pbP != null) {
                r0 += e.a.a.b.b.a.h(3, this.pbP);
            }
            if (this.wgR != null) {
                r0 += e.a.a.b.b.a.h(4, this.wgR);
            }
            r0 = (r0 + e.a.a.a.fR(5, this.whm)) + e.a.a.a.fR(6, this.whn);
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(7, this.ngo);
            }
            r0 += e.a.a.a.fR(8, this.bZN);
            if (this.niZ != null) {
                r0 += e.a.a.b.b.a.h(9, this.niZ);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.nfe == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.pbP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wv wvVar = (wv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wvVar.fon = aVar3.Avy.readString();
                    return 0;
                case 2:
                    wvVar.nfe = aVar3.Avy.readString();
                    return 0;
                case 3:
                    wvVar.pbP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    wvVar.wgR = aVar3.Avy.readString();
                    return 0;
                case 5:
                    wvVar.whm = aVar3.Avy.ry();
                    return 0;
                case 6:
                    wvVar.whn = aVar3.Avy.ry();
                    return 0;
                case 7:
                    wvVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 8:
                    wvVar.bZN = aVar3.Avy.ry();
                    return 0;
                case 9:
                    wvVar.niZ = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
