package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class eo extends bcv {
    public long kti;
    public int rYW;
    public int vJO;
    public LinkedList<ov> vJP = new LinkedList();
    public String vJQ;
    public String vJR;
    public String vJS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vJO);
            aVar.d(3, 8, this.vJP);
            if (this.vJQ != null) {
                aVar.g(4, this.vJQ);
            }
            if (this.vJR != null) {
                aVar.g(5, this.vJR);
            }
            aVar.fU(6, this.rYW);
            aVar.S(7, this.kti);
            if (this.vJS == null) {
                return 0;
            }
            aVar.g(8, this.vJS);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vJO)) + e.a.a.a.c(3, 8, this.vJP);
            if (this.vJQ != null) {
                r0 += e.a.a.b.b.a.h(4, this.vJQ);
            }
            if (this.vJR != null) {
                r0 += e.a.a.b.b.a.h(5, this.vJR);
            }
            r0 = (r0 + e.a.a.a.fR(6, this.rYW)) + e.a.a.a.R(7, this.kti);
            if (this.vJS != null) {
                r0 += e.a.a.b.b.a.h(8, this.vJS);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vJP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
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
            eo eoVar = (eo) objArr[1];
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
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        eoVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    eoVar.vJO = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new ov();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        eoVar.vJP.add(fdVar);
                    }
                    return 0;
                case 4:
                    eoVar.vJQ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    eoVar.vJR = aVar3.Avy.readString();
                    return 0;
                case 6:
                    eoVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 7:
                    eoVar.kti = aVar3.Avy.rz();
                    return 0;
                case 8:
                    eoVar.vJS = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
