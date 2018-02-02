package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class r extends a {
    public String ID;
    public LinkedList<t> ktD = new LinkedList();
    public LinkedList<t> ktE = new LinkedList();
    public long ktl;
    public int kto;
    public int ktp;
    public int ktq;
    public long ktr;
    public long kts;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.fU(2, this.kto);
            aVar.fU(3, this.ktp);
            aVar.fU(4, this.ktq);
            aVar.S(5, this.ktl);
            aVar.S(6, this.ktr);
            aVar.S(7, this.kts);
            aVar.d(8, 8, this.ktD);
            aVar.d(9, 8, this.ktE);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            return (((((((r0 + e.a.a.a.fR(2, this.kto)) + e.a.a.a.fR(3, this.ktp)) + e.a.a.a.fR(4, this.ktq)) + e.a.a.a.R(5, this.ktl)) + e.a.a.a.R(6, this.ktr)) + e.a.a.a.R(7, this.kts)) + e.a.a.a.c(8, 8, this.ktD)) + e.a.a.a.c(9, 8, this.ktE);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ktD.clear();
            this.ktE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            r rVar = (r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a tVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    rVar.ID = aVar3.Avy.readString();
                    return 0;
                case 2:
                    rVar.kto = aVar3.Avy.ry();
                    return 0;
                case 3:
                    rVar.ktp = aVar3.Avy.ry();
                    return 0;
                case 4:
                    rVar.ktq = aVar3.Avy.ry();
                    return 0;
                case 5:
                    rVar.ktl = aVar3.Avy.rz();
                    return 0;
                case 6:
                    rVar.ktr = aVar3.Avy.rz();
                    return 0;
                case 7:
                    rVar.kts = aVar3.Avy.rz();
                    return 0;
                case 8:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        tVar = new t();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.ktD.add(tVar);
                    }
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        tVar = new t();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, a.a(aVar4))) {
                        }
                        rVar.ktE.add(tVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
