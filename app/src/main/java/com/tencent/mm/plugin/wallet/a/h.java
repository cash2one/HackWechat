package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import java.util.LinkedList;

public final class h extends a {
    public String sDA;
    public b sDD;
    public String sDE;
    public double sDF;
    public LinkedList<e> sDG = new LinkedList();
    public double sDp;
    public LinkedList<q> sDr = new LinkedList();
    public double sDw;
    public double sDx;
    public int sDy;
    public String sDz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.sDE != null) {
                aVar.g(1, this.sDE);
            }
            aVar.b(2, this.sDF);
            aVar.b(3, this.sDp);
            aVar.d(4, 8, this.sDG);
            aVar.d(5, 8, this.sDr);
            aVar.b(6, this.sDw);
            aVar.b(7, this.sDx);
            aVar.fU(8, this.sDy);
            if (this.sDz != null) {
                aVar.g(9, this.sDz);
            }
            if (this.sDA != null) {
                aVar.g(10, this.sDA);
            }
            if (this.sDD == null) {
                return 0;
            }
            aVar.b(11, this.sDD);
            return 0;
        } else if (i == 1) {
            if (this.sDE != null) {
                r0 = e.a.a.b.b.a.h(1, this.sDE) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + (e.a.a.b.b.a.dX(2) + 8)) + (e.a.a.b.b.a.dX(3) + 8)) + e.a.a.a.c(4, 8, this.sDG)) + e.a.a.a.c(5, 8, this.sDr)) + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8)) + e.a.a.a.fR(8, this.sDy);
            if (this.sDz != null) {
                r0 += e.a.a.b.b.a.h(9, this.sDz);
            }
            if (this.sDA != null) {
                r0 += e.a.a.b.b.a.h(10, this.sDA);
            }
            if (this.sDD != null) {
                r0 += e.a.a.a.a(11, this.sDD);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.sDG.clear();
            this.sDr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
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
            a eVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hVar.sDE = aVar3.Avy.readString();
                    return 0;
                case 2:
                    hVar.sDF = aVar3.Avy.readDouble();
                    return 0;
                case 3:
                    hVar.sDp = aVar3.Avy.readDouble();
                    return 0;
                case 4:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        eVar = new e();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        hVar.sDG.add(eVar);
                    }
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        eVar = new q();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        hVar.sDr.add(eVar);
                    }
                    return 0;
                case 6:
                    hVar.sDw = aVar3.Avy.readDouble();
                    return 0;
                case 7:
                    hVar.sDx = aVar3.Avy.readDouble();
                    return 0;
                case 8:
                    hVar.sDy = aVar3.Avy.ry();
                    return 0;
                case 9:
                    hVar.sDz = aVar3.Avy.readString();
                    return 0;
                case 10:
                    hVar.sDA = aVar3.Avy.readString();
                    return 0;
                case 11:
                    hVar.sDD = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
