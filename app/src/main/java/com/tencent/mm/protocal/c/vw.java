package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class vw extends a {
    public boolean wfX;
    public boolean wfY;
    public boolean wfZ;
    public boolean wga;
    public boolean wgb;
    public boolean wgc;
    public boolean wgd;
    public boolean wge;
    public boolean wgf;
    public boolean wgg;
    public boolean wgh;
    public boolean wgi;
    public boolean wgj;
    public boolean wgk;
    public boolean wgl;
    public boolean wgm;
    public boolean wgn;
    public boolean wgo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.al(1, this.wfX);
            aVar.al(2, this.wfY);
            aVar.al(3, this.wfZ);
            aVar.al(4, this.wga);
            aVar.al(5, this.wgb);
            aVar.al(6, this.wgc);
            aVar.al(7, this.wgd);
            aVar.al(8, this.wge);
            aVar.al(9, this.wgf);
            aVar.al(10, this.wgg);
            aVar.al(11, this.wgh);
            aVar.al(12, this.wgi);
            aVar.al(13, this.wgj);
            aVar.al(14, this.wgk);
            aVar.al(15, this.wgl);
            aVar.al(16, this.wgm);
            aVar.al(17, this.wgn);
            aVar.al(18, this.wgo);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((((((e.a.a.b.b.a.dX(1) + 1) + 0) + (e.a.a.b.b.a.dX(2) + 1)) + (e.a.a.b.b.a.dX(3) + 1)) + (e.a.a.b.b.a.dX(4) + 1)) + (e.a.a.b.b.a.dX(5) + 1)) + (e.a.a.b.b.a.dX(6) + 1)) + (e.a.a.b.b.a.dX(7) + 1)) + (e.a.a.b.b.a.dX(8) + 1)) + (e.a.a.b.b.a.dX(9) + 1)) + (e.a.a.b.b.a.dX(10) + 1)) + (e.a.a.b.b.a.dX(11) + 1)) + (e.a.a.b.b.a.dX(12) + 1)) + (e.a.a.b.b.a.dX(13) + 1)) + (e.a.a.b.b.a.dX(14) + 1)) + (e.a.a.b.b.a.dX(15) + 1)) + (e.a.a.b.b.a.dX(16) + 1)) + (e.a.a.b.b.a.dX(17) + 1)) + (e.a.a.b.b.a.dX(18) + 1);
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
                vw vwVar = (vw) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        vwVar.wfX = aVar3.cJC();
                        return 0;
                    case 2:
                        vwVar.wfY = aVar3.cJC();
                        return 0;
                    case 3:
                        vwVar.wfZ = aVar3.cJC();
                        return 0;
                    case 4:
                        vwVar.wga = aVar3.cJC();
                        return 0;
                    case 5:
                        vwVar.wgb = aVar3.cJC();
                        return 0;
                    case 6:
                        vwVar.wgc = aVar3.cJC();
                        return 0;
                    case 7:
                        vwVar.wgd = aVar3.cJC();
                        return 0;
                    case 8:
                        vwVar.wge = aVar3.cJC();
                        return 0;
                    case 9:
                        vwVar.wgf = aVar3.cJC();
                        return 0;
                    case 10:
                        vwVar.wgg = aVar3.cJC();
                        return 0;
                    case 11:
                        vwVar.wgh = aVar3.cJC();
                        return 0;
                    case 12:
                        vwVar.wgi = aVar3.cJC();
                        return 0;
                    case 13:
                        vwVar.wgj = aVar3.cJC();
                        return 0;
                    case 14:
                        vwVar.wgk = aVar3.cJC();
                        return 0;
                    case 15:
                        vwVar.wgl = aVar3.cJC();
                        return 0;
                    case 16:
                        vwVar.wgm = aVar3.cJC();
                        return 0;
                    case 17:
                        vwVar.wgn = aVar3.cJC();
                        return 0;
                    case 18:
                        vwVar.wgo = aVar3.cJC();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
