package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class v extends bdf {
    public int liH = 268513600;
    public String liI = "请求不成功，请稍候再试";
    public int state;
    public String title;
    public int type;
    public String vCW;
    public int vDA;
    public int vDB;
    public int vDC;
    public long vDD;
    public long vDE;
    public long vDF;
    public int vDG;
    public String vDH;
    public int vDI;
    public long vDJ;
    public LinkedList<t> vDb = new LinkedList();
    public int vDh;
    public String vDr;
    public String vDv;
    public long vDw;
    public int vDx;
    public long vDy;
    public int vDz;

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
            if (this.vCW != null) {
                aVar.g(4, this.vCW);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            aVar.fU(6, this.type);
            if (this.vDv != null) {
                aVar.g(7, this.vDv);
            }
            aVar.S(8, this.vDw);
            aVar.fU(9, this.vDx);
            aVar.S(10, this.vDy);
            aVar.fU(11, this.vDz);
            aVar.fU(12, this.state);
            aVar.fU(13, this.vDA);
            aVar.fU(14, this.vDB);
            aVar.fU(15, this.vDh);
            aVar.fU(16, this.vDC);
            aVar.S(17, this.vDD);
            aVar.S(18, this.vDE);
            aVar.S(19, this.vDF);
            aVar.fU(20, this.vDG);
            if (this.vDr != null) {
                aVar.g(21, this.vDr);
            }
            aVar.d(22, 8, this.vDb);
            if (this.vDH != null) {
                aVar.g(23, this.vDH);
            }
            aVar.fU(24, this.vDI);
            aVar.S(25, this.vDJ);
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
            if (this.vCW != null) {
                r0 += e.a.a.b.b.a.h(4, this.vCW);
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(5, this.title);
            }
            r0 += e.a.a.a.fR(6, this.type);
            if (this.vDv != null) {
                r0 += e.a.a.b.b.a.h(7, this.vDv);
            }
            r0 = ((((((((((((r0 + e.a.a.a.R(8, this.vDw)) + e.a.a.a.fR(9, this.vDx)) + e.a.a.a.R(10, this.vDy)) + e.a.a.a.fR(11, this.vDz)) + e.a.a.a.fR(12, this.state)) + e.a.a.a.fR(13, this.vDA)) + e.a.a.a.fR(14, this.vDB)) + e.a.a.a.fR(15, this.vDh)) + e.a.a.a.fR(16, this.vDC)) + e.a.a.a.R(17, this.vDD)) + e.a.a.a.R(18, this.vDE)) + e.a.a.a.R(19, this.vDF)) + e.a.a.a.fR(20, this.vDG);
            if (this.vDr != null) {
                r0 += e.a.a.b.b.a.h(21, this.vDr);
            }
            r0 += e.a.a.a.c(22, 8, this.vDb);
            if (this.vDH != null) {
                r0 += e.a.a.b.b.a.h(23, this.vDH);
            }
            return (r0 + e.a.a.a.fR(24, this.vDI)) + e.a.a.a.R(25, this.vDJ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vDb.clear();
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
            v vVar = (v) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        vVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    vVar.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    vVar.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    vVar.vCW = aVar3.Avy.readString();
                    return 0;
                case 5:
                    vVar.title = aVar3.Avy.readString();
                    return 0;
                case 6:
                    vVar.type = aVar3.Avy.ry();
                    return 0;
                case 7:
                    vVar.vDv = aVar3.Avy.readString();
                    return 0;
                case 8:
                    vVar.vDw = aVar3.Avy.rz();
                    return 0;
                case 9:
                    vVar.vDx = aVar3.Avy.ry();
                    return 0;
                case 10:
                    vVar.vDy = aVar3.Avy.rz();
                    return 0;
                case 11:
                    vVar.vDz = aVar3.Avy.ry();
                    return 0;
                case 12:
                    vVar.state = aVar3.Avy.ry();
                    return 0;
                case 13:
                    vVar.vDA = aVar3.Avy.ry();
                    return 0;
                case 14:
                    vVar.vDB = aVar3.Avy.ry();
                    return 0;
                case 15:
                    vVar.vDh = aVar3.Avy.ry();
                    return 0;
                case 16:
                    vVar.vDC = aVar3.Avy.ry();
                    return 0;
                case 17:
                    vVar.vDD = aVar3.Avy.rz();
                    return 0;
                case 18:
                    vVar.vDE = aVar3.Avy.rz();
                    return 0;
                case 19:
                    vVar.vDF = aVar3.Avy.rz();
                    return 0;
                case 20:
                    vVar.vDG = aVar3.Avy.ry();
                    return 0;
                case 21:
                    vVar.vDr = aVar3.Avy.readString();
                    return 0;
                case 22:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        feVar = new t();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        vVar.vDb.add(feVar);
                    }
                    return 0;
                case 23:
                    vVar.vDH = aVar3.Avy.readString();
                    return 0;
                case 24:
                    vVar.vDI = aVar3.Avy.ry();
                    return 0;
                case 25:
                    vVar.vDJ = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
