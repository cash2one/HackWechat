package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class xb extends bcv {
    public String ngo;
    public String nkB;
    public String nku;
    public int rYW;
    public int vDY;
    public String vLX;
    public au vQS;
    public String vVu;
    public String vWg;
    public String vWh;
    public String vWi;
    public String vWj;
    public String whp;
    public String whs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            if (this.vWg != null) {
                aVar.g(3, this.vWg);
            }
            if (this.vLX != null) {
                aVar.g(4, this.vLX);
            }
            if (this.vWh != null) {
                aVar.g(5, this.vWh);
            }
            if (this.vWi != null) {
                aVar.g(6, this.vWi);
            }
            if (this.vWj != null) {
                aVar.g(7, this.vWj);
            }
            if (this.vVu != null) {
                aVar.g(8, this.vVu);
            }
            if (this.whp != null) {
                aVar.g(9, this.whp);
            }
            aVar.fU(10, this.vDY);
            if (this.nkB != null) {
                aVar.g(11, this.nkB);
            }
            if (this.nku != null) {
                aVar.g(12, this.nku);
            }
            if (this.whs != null) {
                aVar.g(13, this.whs);
            }
            if (this.vQS != null) {
                aVar.fW(14, this.vQS.bke());
                this.vQS.a(aVar);
            }
            aVar.fU(15, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            if (this.vWg != null) {
                r0 += e.a.a.b.b.a.h(3, this.vWg);
            }
            if (this.vLX != null) {
                r0 += e.a.a.b.b.a.h(4, this.vLX);
            }
            if (this.vWh != null) {
                r0 += e.a.a.b.b.a.h(5, this.vWh);
            }
            if (this.vWi != null) {
                r0 += e.a.a.b.b.a.h(6, this.vWi);
            }
            if (this.vWj != null) {
                r0 += e.a.a.b.b.a.h(7, this.vWj);
            }
            if (this.vVu != null) {
                r0 += e.a.a.b.b.a.h(8, this.vVu);
            }
            if (this.whp != null) {
                r0 += e.a.a.b.b.a.h(9, this.whp);
            }
            r0 += e.a.a.a.fR(10, this.vDY);
            if (this.nkB != null) {
                r0 += e.a.a.b.b.a.h(11, this.nkB);
            }
            if (this.nku != null) {
                r0 += e.a.a.b.b.a.h(12, this.nku);
            }
            if (this.whs != null) {
                r0 += e.a.a.b.b.a.h(13, this.whs);
            }
            if (this.vQS != null) {
                r0 += e.a.a.a.fT(14, this.vQS.bke());
            }
            return r0 + e.a.a.a.fR(15, this.rYW);
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
            xb xbVar = (xb) objArr[1];
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
                        xbVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    xbVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    xbVar.vWg = aVar3.Avy.readString();
                    return 0;
                case 4:
                    xbVar.vLX = aVar3.Avy.readString();
                    return 0;
                case 5:
                    xbVar.vWh = aVar3.Avy.readString();
                    return 0;
                case 6:
                    xbVar.vWi = aVar3.Avy.readString();
                    return 0;
                case 7:
                    xbVar.vWj = aVar3.Avy.readString();
                    return 0;
                case 8:
                    xbVar.vVu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    xbVar.whp = aVar3.Avy.readString();
                    return 0;
                case 10:
                    xbVar.vDY = aVar3.Avy.ry();
                    return 0;
                case 11:
                    xbVar.nkB = aVar3.Avy.readString();
                    return 0;
                case 12:
                    xbVar.nku = aVar3.Avy.readString();
                    return 0;
                case 13:
                    xbVar.whs = aVar3.Avy.readString();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new au();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        xbVar.vQS = fdVar;
                    }
                    return 0;
                case 15:
                    xbVar.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
