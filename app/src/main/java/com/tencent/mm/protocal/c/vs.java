package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class vs extends a {
    public int wfk;
    public int wfl;
    public int wfm;
    public int wfn;
    public int wfo;
    public int wfp;
    public int wfq;
    public int wfr;
    public int wfs;
    public int wft;
    public int wfu;
    public int wfv;
    public int wfw;
    public int wfx;
    public int wfy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.wfk);
            aVar.fU(2, this.wfl);
            aVar.fU(3, this.wfm);
            aVar.fU(4, this.wfn);
            aVar.fU(5, this.wfo);
            aVar.fU(6, this.wfp);
            aVar.fU(7, this.wfq);
            aVar.fU(8, this.wfr);
            aVar.fU(9, this.wfs);
            aVar.fU(10, this.wft);
            aVar.fU(11, this.wfu);
            aVar.fU(12, this.wfv);
            aVar.fU(13, this.wfw);
            aVar.fU(14, this.wfx);
            aVar.fU(15, this.wfy);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((e.a.a.a.fR(1, this.wfk) + 0) + e.a.a.a.fR(2, this.wfl)) + e.a.a.a.fR(3, this.wfm)) + e.a.a.a.fR(4, this.wfn)) + e.a.a.a.fR(5, this.wfo)) + e.a.a.a.fR(6, this.wfp)) + e.a.a.a.fR(7, this.wfq)) + e.a.a.a.fR(8, this.wfr)) + e.a.a.a.fR(9, this.wfs)) + e.a.a.a.fR(10, this.wft)) + e.a.a.a.fR(11, this.wfu)) + e.a.a.a.fR(12, this.wfv)) + e.a.a.a.fR(13, this.wfw)) + e.a.a.a.fR(14, this.wfx)) + e.a.a.a.fR(15, this.wfy);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJE();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                vs vsVar = (vs) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        vsVar.wfk = aVar3.Avy.ry();
                        return 0;
                    case 2:
                        vsVar.wfl = aVar3.Avy.ry();
                        return 0;
                    case 3:
                        vsVar.wfm = aVar3.Avy.ry();
                        return 0;
                    case 4:
                        vsVar.wfn = aVar3.Avy.ry();
                        return 0;
                    case 5:
                        vsVar.wfo = aVar3.Avy.ry();
                        return 0;
                    case 6:
                        vsVar.wfp = aVar3.Avy.ry();
                        return 0;
                    case 7:
                        vsVar.wfq = aVar3.Avy.ry();
                        return 0;
                    case 8:
                        vsVar.wfr = aVar3.Avy.ry();
                        return 0;
                    case 9:
                        vsVar.wfs = aVar3.Avy.ry();
                        return 0;
                    case 10:
                        vsVar.wft = aVar3.Avy.ry();
                        return 0;
                    case 11:
                        vsVar.wfu = aVar3.Avy.ry();
                        return 0;
                    case 12:
                        vsVar.wfv = aVar3.Avy.ry();
                        return 0;
                    case 13:
                        vsVar.wfw = aVar3.Avy.ry();
                        return 0;
                    case 14:
                        vsVar.wfx = aVar3.Avy.ry();
                        return 0;
                    case 15:
                        vsVar.wfy = aVar3.Avy.ry();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
