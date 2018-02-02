package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class it extends bcv {
    public int fCR;
    public int pKd;
    public String pLh;
    public String pLi;
    public int pLm;
    public String pLn;
    public String pLo;
    public int scene;
    public vu vHt;
    public String vHu;
    public int vHv;
    public String vOQ;
    public String vOW;
    public String vOX;
    public String vOY;
    public int vOZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vOW == null) {
                throw new b("Not all required fields were included: qrcode_id");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.pLn != null) {
                aVar.g(2, this.pLn);
            }
            if (this.vOW != null) {
                aVar.g(3, this.vOW);
            }
            aVar.fU(4, this.scene);
            if (this.vOX != null) {
                aVar.g(5, this.vOX);
            }
            if (this.pLh != null) {
                aVar.g(6, this.pLh);
            }
            aVar.fU(7, this.vHv);
            aVar.fU(8, this.fCR);
            if (this.pLo != null) {
                aVar.g(9, this.pLo);
            }
            if (this.pLi != null) {
                aVar.g(10, this.pLi);
            }
            if (this.vOY != null) {
                aVar.g(11, this.vOY);
            }
            aVar.fU(12, this.vOZ);
            aVar.fU(13, this.pLm);
            if (this.vHu != null) {
                aVar.g(14, this.vHu);
            }
            if (this.vHt != null) {
                aVar.fW(15, this.vHt.bke());
                this.vHt.a(aVar);
            }
            if (this.vOQ != null) {
                aVar.g(16, this.vOQ);
            }
            aVar.fU(17, this.pKd);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.pLn != null) {
                r0 += e.a.a.b.b.a.h(2, this.pLn);
            }
            if (this.vOW != null) {
                r0 += e.a.a.b.b.a.h(3, this.vOW);
            }
            r0 += e.a.a.a.fR(4, this.scene);
            if (this.vOX != null) {
                r0 += e.a.a.b.b.a.h(5, this.vOX);
            }
            if (this.pLh != null) {
                r0 += e.a.a.b.b.a.h(6, this.pLh);
            }
            r0 = (r0 + e.a.a.a.fR(7, this.vHv)) + e.a.a.a.fR(8, this.fCR);
            if (this.pLo != null) {
                r0 += e.a.a.b.b.a.h(9, this.pLo);
            }
            if (this.pLi != null) {
                r0 += e.a.a.b.b.a.h(10, this.pLi);
            }
            if (this.vOY != null) {
                r0 += e.a.a.b.b.a.h(11, this.vOY);
            }
            r0 = (r0 + e.a.a.a.fR(12, this.vOZ)) + e.a.a.a.fR(13, this.pLm);
            if (this.vHu != null) {
                r0 += e.a.a.b.b.a.h(14, this.vHu);
            }
            if (this.vHt != null) {
                r0 += e.a.a.a.fT(15, this.vHt.bke());
            }
            if (this.vOQ != null) {
                r0 += e.a.a.b.b.a.h(16, this.vOQ);
            }
            return r0 + e.a.a.a.fR(17, this.pKd);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vOW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: qrcode_id");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            it itVar = (it) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        itVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    itVar.pLn = aVar3.Avy.readString();
                    return 0;
                case 3:
                    itVar.vOW = aVar3.Avy.readString();
                    return 0;
                case 4:
                    itVar.scene = aVar3.Avy.ry();
                    return 0;
                case 5:
                    itVar.vOX = aVar3.Avy.readString();
                    return 0;
                case 6:
                    itVar.pLh = aVar3.Avy.readString();
                    return 0;
                case 7:
                    itVar.vHv = aVar3.Avy.ry();
                    return 0;
                case 8:
                    itVar.fCR = aVar3.Avy.ry();
                    return 0;
                case 9:
                    itVar.pLo = aVar3.Avy.readString();
                    return 0;
                case 10:
                    itVar.pLi = aVar3.Avy.readString();
                    return 0;
                case 11:
                    itVar.vOY = aVar3.Avy.readString();
                    return 0;
                case 12:
                    itVar.vOZ = aVar3.Avy.ry();
                    return 0;
                case 13:
                    itVar.pLm = aVar3.Avy.ry();
                    return 0;
                case 14:
                    itVar.vHu = aVar3.Avy.readString();
                    return 0;
                case 15:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new vu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        itVar.vHt = fdVar;
                    }
                    return 0;
                case 16:
                    itVar.vOQ = aVar3.Avy.readString();
                    return 0;
                case 17:
                    itVar.pKd = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
