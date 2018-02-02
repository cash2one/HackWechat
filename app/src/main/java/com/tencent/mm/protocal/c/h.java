package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class h extends bcv {
    public int scene;
    public String title;
    public String vCX;
    public LinkedList<j> vDb = new LinkedList();
    public au vDc;
    public long vDd;
    public long vDf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            aVar.S(3, this.vDf);
            aVar.d(5, 8, this.vDb);
            aVar.fU(7, this.scene);
            if (this.vCX != null) {
                aVar.g(8, this.vCX);
            }
            if (this.vDc != null) {
                aVar.fW(9, this.vDc.bke());
                this.vDc.a(aVar);
            }
            aVar.S(10, this.vDd);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(2, this.title);
            }
            r0 = ((r0 + e.a.a.a.R(3, this.vDf)) + e.a.a.a.c(5, 8, this.vDb)) + e.a.a.a.fR(7, this.scene);
            if (this.vCX != null) {
                r0 += e.a.a.b.b.a.h(8, this.vCX);
            }
            if (this.vDc != null) {
                r0 += e.a.a.a.fT(9, this.vDc.bke());
            }
            return r0 + e.a.a.a.R(10, this.vDd);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vDb.clear();
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
            h hVar = (h) objArr[1];
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
                        hVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    hVar.title = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hVar.vDf = aVar3.Avy.rz();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new j();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        hVar.vDb.add(fdVar);
                    }
                    return 0;
                case 7:
                    hVar.scene = aVar3.Avy.ry();
                    return 0;
                case 8:
                    hVar.vCX = aVar3.Avy.readString();
                    return 0;
                case 9:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        fdVar = new au();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        hVar.vDc = fdVar;
                    }
                    return 0;
                case 10:
                    hVar.vDd = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
