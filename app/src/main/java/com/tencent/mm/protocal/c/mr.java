package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class mr extends bcv {
    public String nfn;
    public String nkB;
    public String nko;
    public int rYW;
    public int vHW;
    public int vVp;
    public LinkedList<bdo> vVq = new LinkedList();
    public String vVr;
    public String vVs;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vHW);
            if (this.nko != null) {
                aVar.g(3, this.nko);
            }
            if (this.nkB != null) {
                aVar.g(4, this.nkB);
            }
            if (this.nfn != null) {
                aVar.g(5, this.nfn);
            }
            aVar.fU(6, this.vVp);
            aVar.d(7, 8, this.vVq);
            if (this.vVr != null) {
                aVar.g(8, this.vVr);
            }
            if (this.vVs != null) {
                aVar.g(9, this.vVs);
            }
            aVar.fU(10, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vHW);
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(3, this.nko);
            }
            if (this.nkB != null) {
                r0 += e.a.a.b.b.a.h(4, this.nkB);
            }
            if (this.nfn != null) {
                r0 += e.a.a.b.b.a.h(5, this.nfn);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.vVp)) + e.a.a.a.c(7, 8, this.vVq);
            if (this.vVr != null) {
                r0 += e.a.a.b.b.a.h(8, this.vVr);
            }
            if (this.vVs != null) {
                r0 += e.a.a.b.b.a.h(9, this.vVs);
            }
            return r0 + e.a.a.a.fR(10, this.rYW);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vVq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            mr mrVar = (mr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        mrVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    mrVar.vHW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    mrVar.nko = aVar3.Avy.readString();
                    return 0;
                case 4:
                    mrVar.nkB = aVar3.Avy.readString();
                    return 0;
                case 5:
                    mrVar.nfn = aVar3.Avy.readString();
                    return 0;
                case 6:
                    mrVar.vVp = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, com.tencent.mm.bq.a.a(aVar4))) {
                        }
                        mrVar.vVq.add(fdVar);
                    }
                    return 0;
                case 8:
                    mrVar.vVr = aVar3.Avy.readString();
                    return 0;
                case 9:
                    mrVar.vVs = aVar3.Avy.readString();
                    return 0;
                case 10:
                    mrVar.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
