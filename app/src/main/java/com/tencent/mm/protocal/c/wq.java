package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class wq extends a {
    public String nfn;
    public String vIO;
    public int wgQ;
    public String wgR;
    public String wgZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfn == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.wgZ == null) {
                throw new b("Not all required fields were included: RecommendKey");
            } else {
                if (this.nfn != null) {
                    aVar.g(1, this.nfn);
                }
                if (this.wgZ != null) {
                    aVar.g(2, this.wgZ);
                }
                if (this.vIO != null) {
                    aVar.g(3, this.vIO);
                }
                aVar.fU(4, this.wgQ);
                if (this.wgR == null) {
                    return 0;
                }
                aVar.g(5, this.wgR);
                return 0;
            }
        } else if (i == 1) {
            if (this.nfn != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfn) + 0;
            } else {
                r0 = 0;
            }
            if (this.wgZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.wgZ);
            }
            if (this.vIO != null) {
                r0 += e.a.a.b.b.a.h(3, this.vIO);
            }
            r0 += e.a.a.a.fR(4, this.wgQ);
            if (this.wgR != null) {
                r0 += e.a.a.b.b.a.h(5, this.wgR);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.nfn == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.wgZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RecommendKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            wq wqVar = (wq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wqVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 2:
                    wqVar.wgZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    wqVar.vIO = aVar3.Avy.readString();
                    return 0;
                case 4:
                    wqVar.wgQ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    wqVar.wgR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
