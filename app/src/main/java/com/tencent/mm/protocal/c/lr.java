package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lr extends bdf {
    public String desc;
    public int liH;
    public String liI;
    public String pKT;
    public LinkedList<Integer> vTY = new LinkedList();
    public int vUa;
    public String vUl;
    public String vUo;
    public String vUr;
    public String vUt;
    public String vUu;
    public String vUw;

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
            if (this.vUo != null) {
                aVar.g(4, this.vUo);
            }
            aVar.d(5, 2, this.vTY);
            if (this.desc != null) {
                aVar.g(6, this.desc);
            }
            if (this.vUw != null) {
                aVar.g(7, this.vUw);
            }
            if (this.pKT != null) {
                aVar.g(8, this.pKT);
            }
            if (this.vUr != null) {
                aVar.g(9, this.vUr);
            }
            if (this.vUt != null) {
                aVar.g(10, this.vUt);
            }
            if (this.vUu != null) {
                aVar.g(11, this.vUu);
            }
            aVar.fU(12, this.vUa);
            if (this.vUl == null) {
                return 0;
            }
            aVar.g(13, this.vUl);
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
            if (this.vUo != null) {
                r0 += e.a.a.b.b.a.h(4, this.vUo);
            }
            r0 += e.a.a.a.c(5, 2, this.vTY);
            if (this.desc != null) {
                r0 += e.a.a.b.b.a.h(6, this.desc);
            }
            if (this.vUw != null) {
                r0 += e.a.a.b.b.a.h(7, this.vUw);
            }
            if (this.pKT != null) {
                r0 += e.a.a.b.b.a.h(8, this.pKT);
            }
            if (this.vUr != null) {
                r0 += e.a.a.b.b.a.h(9, this.vUr);
            }
            if (this.vUt != null) {
                r0 += e.a.a.b.b.a.h(10, this.vUt);
            }
            if (this.vUu != null) {
                r0 += e.a.a.b.b.a.h(11, this.vUu);
            }
            r0 += e.a.a.a.fR(12, this.vUa);
            if (this.vUl != null) {
                r0 += e.a.a.b.b.a.h(13, this.vUl);
            }
            return r0;
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
            lr lrVar = (lr) objArr[1];
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
                        lrVar.wJr = feVar;
                    }
                    return 0;
                case 2:
                    lrVar.liH = aVar3.Avy.ry();
                    return 0;
                case 3:
                    lrVar.liI = aVar3.Avy.readString();
                    return 0;
                case 4:
                    lrVar.vUo = aVar3.Avy.readString();
                    return 0;
                case 5:
                    lrVar.vTY.add(Integer.valueOf(aVar3.Avy.ry()));
                    return 0;
                case 6:
                    lrVar.desc = aVar3.Avy.readString();
                    return 0;
                case 7:
                    lrVar.vUw = aVar3.Avy.readString();
                    return 0;
                case 8:
                    lrVar.pKT = aVar3.Avy.readString();
                    return 0;
                case 9:
                    lrVar.vUr = aVar3.Avy.readString();
                    return 0;
                case 10:
                    lrVar.vUt = aVar3.Avy.readString();
                    return 0;
                case 11:
                    lrVar.vUu = aVar3.Avy.readString();
                    return 0;
                case 12:
                    lrVar.vUa = aVar3.Avy.ry();
                    return 0;
                case 13:
                    lrVar.vUl = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
