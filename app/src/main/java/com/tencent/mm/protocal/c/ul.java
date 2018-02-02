package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ul extends bcv {
    public int vDW;
    public float vQt;
    public float vQu;
    public String vZK;
    public String wcq;
    public int wcr;
    public String wcs;
    public String wct;
    public int wcu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vDW);
            if (this.wcq != null) {
                aVar.g(3, this.wcq);
            }
            aVar.m(4, this.vQt);
            aVar.m(5, this.vQu);
            aVar.fU(6, this.wcr);
            if (this.wcs != null) {
                aVar.g(7, this.wcs);
            }
            if (this.wct != null) {
                aVar.g(8, this.wct);
            }
            aVar.fU(9, this.wcu);
            if (this.vZK == null) {
                return 0;
            }
            aVar.g(10, this.vZK);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vDW);
            if (this.wcq != null) {
                r0 += e.a.a.b.b.a.h(3, this.wcq);
            }
            r0 = ((r0 + (e.a.a.b.b.a.dX(4) + 4)) + (e.a.a.b.b.a.dX(5) + 4)) + e.a.a.a.fR(6, this.wcr);
            if (this.wcs != null) {
                r0 += e.a.a.b.b.a.h(7, this.wcs);
            }
            if (this.wct != null) {
                r0 += e.a.a.b.b.a.h(8, this.wct);
            }
            r0 += e.a.a.a.fR(9, this.wcu);
            if (this.vZK != null) {
                r0 += e.a.a.b.b.a.h(10, this.vZK);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bq.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bq.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ul ulVar = (ul) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        ulVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    ulVar.vDW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    ulVar.wcq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ulVar.vQt = aVar3.Avy.readFloat();
                    return 0;
                case 5:
                    ulVar.vQu = aVar3.Avy.readFloat();
                    return 0;
                case 6:
                    ulVar.wcr = aVar3.Avy.ry();
                    return 0;
                case 7:
                    ulVar.wcs = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ulVar.wct = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ulVar.wcu = aVar3.Avy.ry();
                    return 0;
                case 10:
                    ulVar.vZK = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
