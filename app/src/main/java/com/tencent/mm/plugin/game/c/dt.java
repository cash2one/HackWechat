package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bq.a;

public final class dt extends a {
    public String nfj;
    public String nfo;
    public String nkg;
    public String nkh;
    public String nki;
    public boolean nkj;
    public boolean nkk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nfo != null) {
                aVar.g(1, this.nfo);
            }
            if (this.nkg != null) {
                aVar.g(2, this.nkg);
            }
            if (this.nkh != null) {
                aVar.g(3, this.nkh);
            }
            if (this.nki != null) {
                aVar.g(4, this.nki);
            }
            if (this.nfj != null) {
                aVar.g(5, this.nfj);
            }
            aVar.al(6, this.nkj);
            aVar.al(7, this.nkk);
            return 0;
        } else if (i == 1) {
            if (this.nfo != null) {
                r0 = e.a.a.b.b.a.h(1, this.nfo) + 0;
            } else {
                r0 = 0;
            }
            if (this.nkg != null) {
                r0 += e.a.a.b.b.a.h(2, this.nkg);
            }
            if (this.nkh != null) {
                r0 += e.a.a.b.b.a.h(3, this.nkh);
            }
            if (this.nki != null) {
                r0 += e.a.a.b.b.a.h(4, this.nki);
            }
            if (this.nfj != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfj);
            }
            return (r0 + (e.a.a.b.b.a.dX(6) + 1)) + (e.a.a.b.b.a.dX(7) + 1);
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
            dt dtVar = (dt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dtVar.nfo = aVar3.Avy.readString();
                    return 0;
                case 2:
                    dtVar.nkg = aVar3.Avy.readString();
                    return 0;
                case 3:
                    dtVar.nkh = aVar3.Avy.readString();
                    return 0;
                case 4:
                    dtVar.nki = aVar3.Avy.readString();
                    return 0;
                case 5:
                    dtVar.nfj = aVar3.Avy.readString();
                    return 0;
                case 6:
                    dtVar.nkj = aVar3.cJC();
                    return 0;
                case 7:
                    dtVar.nkk = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
