package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class gx extends bcv {
    public String ksU;
    public String lOo;
    public int vJL;
    public String vJl;
    public String vJz;
    public String vMb;
    public String vMc;
    public int vMd;
    public String vMe;
    public int vMf;
    public String vMg;
    public String vMh;
    public bdn vMi;
    public int vMj;
    public int vMk;
    public int vMl;
    public String vMm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ksU != null) {
                aVar.g(2, this.ksU);
            }
            if (this.vMb != null) {
                aVar.g(3, this.vMb);
            }
            aVar.fU(4, this.vJL);
            if (this.vMc != null) {
                aVar.g(5, this.vMc);
            }
            aVar.fU(6, this.vMd);
            if (this.vMe != null) {
                aVar.g(7, this.vMe);
            }
            if (this.vJl != null) {
                aVar.g(8, this.vJl);
            }
            aVar.fU(9, this.vMf);
            if (this.vMg != null) {
                aVar.g(10, this.vMg);
            }
            if (this.vMh != null) {
                aVar.g(11, this.vMh);
            }
            if (this.vMi != null) {
                aVar.fW(12, this.vMi.bke());
                this.vMi.a(aVar);
            }
            if (this.lOo != null) {
                aVar.g(13, this.lOo);
            }
            aVar.fU(14, this.vMj);
            aVar.fU(15, this.vMk);
            if (this.vJz != null) {
                aVar.g(16, this.vJz);
            }
            aVar.fU(17, this.vMl);
            if (this.vMm == null) {
                return 0;
            }
            aVar.g(18, this.vMm);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(2, this.ksU);
            }
            if (this.vMb != null) {
                r0 += e.a.a.b.b.a.h(3, this.vMb);
            }
            r0 += e.a.a.a.fR(4, this.vJL);
            if (this.vMc != null) {
                r0 += e.a.a.b.b.a.h(5, this.vMc);
            }
            r0 += e.a.a.a.fR(6, this.vMd);
            if (this.vMe != null) {
                r0 += e.a.a.b.b.a.h(7, this.vMe);
            }
            if (this.vJl != null) {
                r0 += e.a.a.b.b.a.h(8, this.vJl);
            }
            r0 += e.a.a.a.fR(9, this.vMf);
            if (this.vMg != null) {
                r0 += e.a.a.b.b.a.h(10, this.vMg);
            }
            if (this.vMh != null) {
                r0 += e.a.a.b.b.a.h(11, this.vMh);
            }
            if (this.vMi != null) {
                r0 += e.a.a.a.fT(12, this.vMi.bke());
            }
            if (this.lOo != null) {
                r0 += e.a.a.b.b.a.h(13, this.lOo);
            }
            r0 = (r0 + e.a.a.a.fR(14, this.vMj)) + e.a.a.a.fR(15, this.vMk);
            if (this.vJz != null) {
                r0 += e.a.a.b.b.a.h(16, this.vJz);
            }
            r0 += e.a.a.a.fR(17, this.vMl);
            if (this.vMm != null) {
                r0 += e.a.a.b.b.a.h(18, this.vMm);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gx gxVar = (gx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        gxVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    gxVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 3:
                    gxVar.vMb = aVar3.Avy.readString();
                    return 0;
                case 4:
                    gxVar.vJL = aVar3.Avy.ry();
                    return 0;
                case 5:
                    gxVar.vMc = aVar3.Avy.readString();
                    return 0;
                case 6:
                    gxVar.vMd = aVar3.Avy.ry();
                    return 0;
                case 7:
                    gxVar.vMe = aVar3.Avy.readString();
                    return 0;
                case 8:
                    gxVar.vJl = aVar3.Avy.readString();
                    return 0;
                case 9:
                    gxVar.vMf = aVar3.Avy.ry();
                    return 0;
                case 10:
                    gxVar.vMg = aVar3.Avy.readString();
                    return 0;
                case 11:
                    gxVar.vMh = aVar3.Avy.readString();
                    return 0;
                case 12:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        gxVar.vMi = fdVar;
                    }
                    return 0;
                case 13:
                    gxVar.lOo = aVar3.Avy.readString();
                    return 0;
                case 14:
                    gxVar.vMj = aVar3.Avy.ry();
                    return 0;
                case 15:
                    gxVar.vMk = aVar3.Avy.ry();
                    return 0;
                case 16:
                    gxVar.vJz = aVar3.Avy.readString();
                    return 0;
                case 17:
                    gxVar.vMl = aVar3.Avy.ry();
                    return 0;
                case 18:
                    gxVar.vMm = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
