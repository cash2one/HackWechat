package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class le extends bdf {
    public String desc;
    public String kHm;
    public String kLA;
    public int liH;
    public String liI;
    public String pKb;
    public String sKt;
    public boolean vTV;
    public String vTW;
    public int vTX;
    public LinkedList<Integer> vTY = new LinkedList();
    public String vTZ;
    public int vUa;
    public int vUb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wJr == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.wJr != null) {
                aVar.fW(1, this.wJr.bke());
                this.wJr.a(aVar);
            }
            aVar.fU(2, this.liH);
            if (this.liI != null) {
                aVar.g(3, this.liI);
            }
            aVar.al(4, this.vTV);
            if (this.pKb != null) {
                aVar.g(5, this.pKb);
            }
            if (this.vTW != null) {
                aVar.g(6, this.vTW);
            }
            if (this.kHm != null) {
                aVar.g(7, this.kHm);
            }
            aVar.fU(8, this.vTX);
            if (this.desc != null) {
                aVar.g(9, this.desc);
            }
            if (this.sKt != null) {
                aVar.g(10, this.sKt);
            }
            aVar.d(11, 2, this.vTY);
            if (this.vTZ != null) {
                aVar.g(12, this.vTZ);
            }
            if (this.kLA != null) {
                aVar.g(13, this.kLA);
            }
            aVar.fU(14, this.vUa);
            aVar.fU(15, this.vUb);
            return 0;
        } else if (i == 1) {
            if (this.wJr != null) {
                r0 = e.a.a.a.fT(1, this.wJr.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.liH);
            if (this.liI != null) {
                r0 += e.a.a.b.b.a.h(3, this.liI);
            }
            r0 += e.a.a.b.b.a.dX(4) + 1;
            if (this.pKb != null) {
                r0 += e.a.a.b.b.a.h(5, this.pKb);
            }
            if (this.vTW != null) {
                r0 += e.a.a.b.b.a.h(6, this.vTW);
            }
            if (this.kHm != null) {
                r0 += e.a.a.b.b.a.h(7, this.kHm);
            }
            r0 += e.a.a.a.fR(8, this.vTX);
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(9, this.desc);
            }
            if (this.sKt != null) {
                r0 += e.a.a.b.b.a.h(10, this.sKt);
            }
            r0 += e.a.a.a.c(11, 2, this.vTY);
            if (this.vTZ != null) {
                r0 += e.a.a.b.b.a.h(12, this.vTZ);
            }
            if (this.kLA != null) {
                r0 += e.a.a.b.b.a.h(13, this.kLA);
            }
            return (r0 + e.a.a.a.fR(14, this.vUa)) + e.a.a.a.fR(15, this.vUb);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vTY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bdf.a(aVar2); r0 > 0; r0 = bdf.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wJr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            le leVar = (le) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a feVar = new fe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        leVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    leVar.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    leVar.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    leVar.vTV = aVar3.cJC();
                    return 0;
                case 5:
                    leVar.pKb = aVar3.Avy.readString();
                    return 0;
                case 6:
                    leVar.vTW = aVar3.Avy.readString();
                    return 0;
                case 7:
                    leVar.kHm = aVar3.Avy.readString();
                    return 0;
                case 8:
                    leVar.vTX = aVar3.Avy.ry();
                    return 0;
                case 9:
                    leVar.desc = aVar3.Avy.readString();
                    return 0;
                case 10:
                    leVar.sKt = aVar3.Avy.readString();
                    return 0;
                case 11:
                    leVar.vTY.add(Integer.valueOf(aVar3.Avy.ry()));
                    return 0;
                case 12:
                    leVar.vTZ = aVar3.Avy.readString();
                    return 0;
                case 13:
                    leVar.kLA = aVar3.Avy.readString();
                    return 0;
                case 14:
                    leVar.vUa = aVar3.Avy.ry();
                    return 0;
                case 15:
                    leVar.vUb = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
