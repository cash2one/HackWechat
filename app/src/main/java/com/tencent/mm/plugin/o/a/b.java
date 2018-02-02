package com.tencent.mm.plugin.o.a;

import com.tencent.mm.bq.a;

public final class b extends a {
    public String fWi;
    public int nBI;
    public String nBJ;
    public String nBK;
    public String nBL;
    public String nBM;
    public String nBN;
    public String nBO;
    public String nBP;
    public String nBQ;
    public String nBR;
    public String title;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.nBI);
            if (this.type != null) {
                aVar.g(2, this.type);
            }
            if (this.title != null) {
                aVar.g(3, this.title);
            }
            if (this.nBJ != null) {
                aVar.g(4, this.nBJ);
            }
            if (this.nBK != null) {
                aVar.g(5, this.nBK);
            }
            if (this.nBL != null) {
                aVar.g(6, this.nBL);
            }
            if (this.nBM != null) {
                aVar.g(7, this.nBM);
            }
            if (this.nBN != null) {
                aVar.g(8, this.nBN);
            }
            if (this.nBO != null) {
                aVar.g(9, this.nBO);
            }
            if (this.nBP != null) {
                aVar.g(10, this.nBP);
            }
            if (this.fWi != null) {
                aVar.g(11, this.fWi);
            }
            if (this.nBQ != null) {
                aVar.g(12, this.nBQ);
            }
            if (this.nBR != null) {
                aVar.g(13, this.nBR);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.nBI) + 0;
            if (this.type != null) {
                r0 += e.a.a.b.b.a.h(2, this.type);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(3, this.title);
            }
            if (this.nBJ != null) {
                r0 += e.a.a.b.b.a.h(4, this.nBJ);
            }
            if (this.nBK != null) {
                r0 += e.a.a.b.b.a.h(5, this.nBK);
            }
            if (this.nBL != null) {
                r0 += e.a.a.b.b.a.h(6, this.nBL);
            }
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(7, this.nBM);
            }
            if (this.nBN != null) {
                r0 += e.a.a.b.b.a.h(8, this.nBN);
            }
            if (this.nBO != null) {
                r0 += e.a.a.b.b.a.h(9, this.nBO);
            }
            if (this.nBP != null) {
                r0 += e.a.a.b.b.a.h(10, this.nBP);
            }
            if (this.fWi != null) {
                r0 += e.a.a.b.b.a.h(11, this.fWi);
            }
            if (this.nBQ != null) {
                r0 += e.a.a.b.b.a.h(12, this.nBQ);
            }
            if (this.nBR != null) {
                return r0 + e.a.a.b.b.a.h(13, this.nBR);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.nBI = aVar3.Avy.ry();
                    return 0;
                case 2:
                    bVar.type = aVar3.Avy.readString();
                    return 0;
                case 3:
                    bVar.title = aVar3.Avy.readString();
                    return 0;
                case 4:
                    bVar.nBJ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    bVar.nBK = aVar3.Avy.readString();
                    return 0;
                case 6:
                    bVar.nBL = aVar3.Avy.readString();
                    return 0;
                case 7:
                    bVar.nBM = aVar3.Avy.readString();
                    return 0;
                case 8:
                    bVar.nBN = aVar3.Avy.readString();
                    return 0;
                case 9:
                    bVar.nBO = aVar3.Avy.readString();
                    return 0;
                case 10:
                    bVar.nBP = aVar3.Avy.readString();
                    return 0;
                case 11:
                    bVar.fWi = aVar3.Avy.readString();
                    return 0;
                case 12:
                    bVar.nBQ = aVar3.Avy.readString();
                    return 0;
                case 13:
                    bVar.nBR = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
