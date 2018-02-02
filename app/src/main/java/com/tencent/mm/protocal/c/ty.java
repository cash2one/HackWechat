package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ty extends bdf {
    public int fLD;
    public int fLE;
    public int fqv;
    public int liH;
    public String liI;
    public String nZa;
    public int nZd;
    public int nZf;
    public String nZg;
    public String nZh;
    public String nZi;
    public int nZj;
    public String ocj;
    public bbg wbY;

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
            aVar.fU(4, this.fqv);
            if (this.nZa != null) {
                aVar.g(5, this.nZa);
            }
            aVar.fU(6, this.fLD);
            aVar.fU(7, this.fLE);
            if (this.ocj != null) {
                aVar.g(8, this.ocj);
            }
            aVar.fU(9, this.nZd);
            if (this.wbY != null) {
                aVar.fW(10, this.wbY.bke());
                this.wbY.a(aVar);
            }
            aVar.fU(11, this.nZf);
            if (this.nZg != null) {
                aVar.g(12, this.nZg);
            }
            if (this.nZh != null) {
                aVar.g(13, this.nZh);
            }
            if (this.nZi != null) {
                aVar.g(14, this.nZi);
            }
            aVar.fU(15, this.nZj);
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
            r0 += e.a.a.a.fR(4, this.fqv);
            if (this.nZa != null) {
                r0 += e.a.a.b.b.a.h(5, this.nZa);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.fLD)) + e.a.a.a.fR(7, this.fLE);
            if (this.ocj != null) {
                r0 += e.a.a.b.b.a.h(8, this.ocj);
            }
            r0 += e.a.a.a.fR(9, this.nZd);
            if (this.wbY != null) {
                r0 += e.a.a.a.fT(10, this.wbY.bke());
            }
            r0 += e.a.a.a.fR(11, this.nZf);
            if (this.nZg != null) {
                r0 += e.a.a.b.b.a.h(12, this.nZg);
            }
            if (this.nZh != null) {
                r0 += e.a.a.b.b.a.h(13, this.nZh);
            }
            if (this.nZi != null) {
                r0 += e.a.a.b.b.a.h(14, this.nZi);
            }
            return r0 + e.a.a.a.fR(15, this.nZj);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ty tyVar = (ty) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a feVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        tyVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    tyVar.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    tyVar.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    tyVar.fqv = aVar3.Avy.ry();
                    return 0;
                case 5:
                    tyVar.nZa = aVar3.Avy.readString();
                    return 0;
                case 6:
                    tyVar.fLD = aVar3.Avy.ry();
                    return 0;
                case 7:
                    tyVar.fLE = aVar3.Avy.ry();
                    return 0;
                case 8:
                    tyVar.ocj = aVar3.Avy.readString();
                    return 0;
                case 9:
                    tyVar.nZd = aVar3.Avy.ry();
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        feVar = new bbg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.a(aVar4, feVar, bdf.a(aVar4))) {
                        }
                        tyVar.wbY = feVar;
                    }
                    return 0;
                case 11:
                    tyVar.nZf = aVar3.Avy.ry();
                    return 0;
                case 12:
                    tyVar.nZg = aVar3.Avy.readString();
                    return 0;
                case 13:
                    tyVar.nZh = aVar3.Avy.readString();
                    return 0;
                case 14:
                    tyVar.nZi = aVar3.Avy.readString();
                    return 0;
                case 15:
                    tyVar.nZj = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
