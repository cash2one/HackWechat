package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class un extends a {
    public String ksU;
    public int ktm;
    public String kub;
    public String wao;
    public String wcv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ksU != null) {
                aVar.g(1, this.ksU);
            }
            if (this.wcv != null) {
                aVar.g(2, this.wcv);
            }
            if (this.kub != null) {
                aVar.g(3, this.kub);
            }
            if (this.wao != null) {
                aVar.g(4, this.wao);
            }
            aVar.fU(5, this.ktm);
            return 0;
        } else if (i == 1) {
            if (this.ksU != null) {
                r0 = e.a.a.b.b.a.h(1, this.ksU) + 0;
            } else {
                r0 = 0;
            }
            if (this.wcv != null) {
                r0 += e.a.a.b.b.a.h(2, this.wcv);
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(3, this.kub);
            }
            if (this.wao != null) {
                r0 += e.a.a.b.b.a.h(4, this.wao);
            }
            return r0 + e.a.a.a.fR(5, this.ktm);
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
            un unVar = (un) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    unVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 2:
                    unVar.wcv = aVar3.Avy.readString();
                    return 0;
                case 3:
                    unVar.kub = aVar3.Avy.readString();
                    return 0;
                case 4:
                    unVar.wao = aVar3.Avy.readString();
                    return 0;
                case 5:
                    unVar.ktm = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
