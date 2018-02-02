package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class wi extends a {
    public String ksU;
    public String kub;
    public String nfL;
    public String nfZ;
    public String nkv;
    public int vEa;
    public String vLX;
    public String vWi;
    public String wgH;
    public String wgI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nkv != null) {
                aVar.g(1, this.nkv);
            }
            if (this.kub != null) {
                aVar.g(2, this.kub);
            }
            if (this.ksU != null) {
                aVar.g(3, this.ksU);
            }
            if (this.nfZ != null) {
                aVar.g(4, this.nfZ);
            }
            if (this.wgH != null) {
                aVar.g(5, this.wgH);
            }
            if (this.wgI != null) {
                aVar.g(6, this.wgI);
            }
            if (this.vLX != null) {
                aVar.g(7, this.vLX);
            }
            if (this.vWi != null) {
                aVar.g(8, this.vWi);
            }
            if (this.nfL != null) {
                aVar.g(9, this.nfL);
            }
            aVar.fU(10, this.vEa);
            return 0;
        } else if (i == 1) {
            if (this.nkv != null) {
                r0 = e.a.a.b.b.a.h(1, this.nkv) + 0;
            } else {
                r0 = 0;
            }
            if (this.kub != null) {
                r0 += e.a.a.b.b.a.h(2, this.kub);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(3, this.ksU);
            }
            if (this.nfZ != null) {
                r0 += e.a.a.b.b.a.h(4, this.nfZ);
            }
            if (this.wgH != null) {
                r0 += e.a.a.b.b.a.h(5, this.wgH);
            }
            if (this.wgI != null) {
                r0 += e.a.a.b.b.a.h(6, this.wgI);
            }
            if (this.vLX != null) {
                r0 += e.a.a.b.b.a.h(7, this.vLX);
            }
            if (this.vWi != null) {
                r0 += e.a.a.b.b.a.h(8, this.vWi);
            }
            if (this.nfL != null) {
                r0 += e.a.a.b.b.a.h(9, this.nfL);
            }
            return r0 + e.a.a.a.fR(10, this.vEa);
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
            wi wiVar = (wi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wiVar.nkv = aVar3.Avy.readString();
                    return 0;
                case 2:
                    wiVar.kub = aVar3.Avy.readString();
                    return 0;
                case 3:
                    wiVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 4:
                    wiVar.nfZ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    wiVar.wgH = aVar3.Avy.readString();
                    return 0;
                case 6:
                    wiVar.wgI = aVar3.Avy.readString();
                    return 0;
                case 7:
                    wiVar.vLX = aVar3.Avy.readString();
                    return 0;
                case 8:
                    wiVar.vWi = aVar3.Avy.readString();
                    return 0;
                case 9:
                    wiVar.nfL = aVar3.Avy.readString();
                    return 0;
                case 10:
                    wiVar.vEa = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
