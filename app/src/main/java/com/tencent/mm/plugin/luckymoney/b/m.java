package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bq.a;

public final class m extends a {
    public String obV;
    public String ocD;
    public String ocE;
    public String ocF;
    public String ocG;
    public long ocq;
    public String ocr;
    public String userName;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ocD != null) {
                aVar.g(1, this.ocD);
            }
            if (this.ocE != null) {
                aVar.g(2, this.ocE);
            }
            aVar.S(3, this.ocq);
            if (this.ocr != null) {
                aVar.g(4, this.ocr);
            }
            if (this.ocF != null) {
                aVar.g(5, this.ocF);
            }
            if (this.obV != null) {
                aVar.g(6, this.obV);
            }
            if (this.ocG != null) {
                aVar.g(7, this.ocG);
            }
            if (this.userName == null) {
                return 0;
            }
            aVar.g(8, this.userName);
            return 0;
        } else if (i == 1) {
            if (this.ocD != null) {
                r0 = e.a.a.b.b.a.h(1, this.ocD) + 0;
            } else {
                r0 = 0;
            }
            if (this.ocE != null) {
                r0 += e.a.a.b.b.a.h(2, this.ocE);
            }
            r0 += e.a.a.a.R(3, this.ocq);
            if (this.ocr != null) {
                r0 += e.a.a.b.b.a.h(4, this.ocr);
            }
            if (this.ocF != null) {
                r0 += e.a.a.b.b.a.h(5, this.ocF);
            }
            if (this.obV != null) {
                r0 += e.a.a.b.b.a.h(6, this.obV);
            }
            if (this.ocG != null) {
                r0 += e.a.a.b.b.a.h(7, this.ocG);
            }
            if (this.userName != null) {
                r0 += e.a.a.b.b.a.h(8, this.userName);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.ocD = aVar3.Avy.readString();
                    return 0;
                case 2:
                    mVar.ocE = aVar3.Avy.readString();
                    return 0;
                case 3:
                    mVar.ocq = aVar3.Avy.rz();
                    return 0;
                case 4:
                    mVar.ocr = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mVar.ocF = aVar3.Avy.readString();
                    return 0;
                case 6:
                    mVar.obV = aVar3.Avy.readString();
                    return 0;
                case 7:
                    mVar.ocG = aVar3.Avy.readString();
                    return 0;
                case 8:
                    mVar.userName = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
