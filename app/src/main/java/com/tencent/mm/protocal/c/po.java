package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class po extends bcv {
    public int ksO;
    public String nfp;
    public aog vYA;
    public LinkedList<bdo> vYB = new LinkedList();
    public String vYC;
    public String vYD;
    public String vYy;
    public String vYz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vYA == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.nfp != null) {
                aVar.g(2, this.nfp);
            }
            if (this.vYy != null) {
                aVar.g(3, this.vYy);
            }
            if (this.vYz != null) {
                aVar.g(4, this.vYz);
            }
            if (this.vYA != null) {
                aVar.fW(5, this.vYA.bke());
                this.vYA.a(aVar);
            }
            aVar.fU(6, this.ksO);
            aVar.d(7, 8, this.vYB);
            if (this.vYC != null) {
                aVar.g(8, this.vYC);
            }
            if (this.vYD == null) {
                return 0;
            }
            aVar.g(9, this.vYD);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nfp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nfp);
            }
            if (this.vYy != null) {
                r0 += e.a.a.b.b.a.h(3, this.vYy);
            }
            if (this.vYz != null) {
                r0 += e.a.a.b.b.a.h(4, this.vYz);
            }
            if (this.vYA != null) {
                r0 += e.a.a.a.fT(5, this.vYA.bke());
            }
            r0 = (r0 + e.a.a.a.fR(6, this.ksO)) + e.a.a.a.c(7, 8, this.vYB);
            if (this.vYC != null) {
                r0 += e.a.a.b.b.a.h(8, this.vYC);
            }
            if (this.vYD != null) {
                r0 += e.a.a.b.b.a.h(9, this.vYD);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vYB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vYA != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            po poVar = (po) objArr[1];
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
                        poVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    poVar.nfp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    poVar.vYy = aVar3.Avy.readString();
                    return 0;
                case 4:
                    poVar.vYz = aVar3.Avy.readString();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new aog();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        poVar.vYA = fdVar;
                    }
                    return 0;
                case 6:
                    poVar.ksO = aVar3.Avy.ry();
                    return 0;
                case 7:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new bdo();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        poVar.vYB.add(fdVar);
                    }
                    return 0;
                case 8:
                    poVar.vYC = aVar3.Avy.readString();
                    return 0;
                case 9:
                    poVar.vYD = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
