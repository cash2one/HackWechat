package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class c extends a {
    public String hef;
    public String name;
    public String paz;
    public int peA;
    public int peB;
    public LinkedList<String> peC = new LinkedList();
    public String peD;
    public LinkedList<String> peE = new LinkedList();
    public LinkedList<b> peF = new LinkedList();
    public LinkedList<String> peG = new LinkedList();
    public int peH;
    public int peI;
    public LinkedList<m> peJ = new LinkedList();
    public LinkedList<a> peK = new LinkedList();
    public k peL;
    public LinkedList<d> pey = new LinkedList();
    public int pez;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            aVar.d(2, 8, this.pey);
            aVar.fU(3, this.pez);
            aVar.fU(4, this.peA);
            aVar.fU(5, this.peB);
            aVar.d(6, 1, this.peC);
            if (this.hef != null) {
                aVar.g(7, this.hef);
            }
            if (this.peD != null) {
                aVar.g(8, this.peD);
            }
            aVar.d(9, 1, this.peE);
            aVar.d(10, 8, this.peF);
            aVar.d(11, 1, this.peG);
            aVar.fU(12, this.peH);
            aVar.fU(13, this.peI);
            aVar.d(14, 8, this.peJ);
            aVar.fU(15, this.version);
            aVar.d(16, 8, this.peK);
            if (this.paz != null) {
                aVar.g(17, this.paz);
            }
            if (this.peL == null) {
                return 0;
            }
            aVar.fW(18, this.peL.bke());
            this.peL.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                r0 = e.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + e.a.a.a.c(2, 8, this.pey)) + e.a.a.a.fR(3, this.pez)) + e.a.a.a.fR(4, this.peA)) + e.a.a.a.fR(5, this.peB)) + e.a.a.a.c(6, 1, this.peC);
            if (this.hef != null) {
                r0 += e.a.a.b.b.a.h(7, this.hef);
            }
            if (this.peD != null) {
                r0 += e.a.a.b.b.a.h(8, this.peD);
            }
            r0 = (((((((r0 + e.a.a.a.c(9, 1, this.peE)) + e.a.a.a.c(10, 8, this.peF)) + e.a.a.a.c(11, 1, this.peG)) + e.a.a.a.fR(12, this.peH)) + e.a.a.a.fR(13, this.peI)) + e.a.a.a.c(14, 8, this.peJ)) + e.a.a.a.fR(15, this.version)) + e.a.a.a.c(16, 8, this.peK);
            if (this.paz != null) {
                r0 += e.a.a.b.b.a.h(17, this.paz);
            }
            if (this.peL != null) {
                r0 += e.a.a.a.fT(18, this.peL.bke());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.pey.clear();
            this.peC.clear();
            this.peE.clear();
            this.peF.clear();
            this.peG.clear();
            this.peJ.clear();
            this.peK.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            a dVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.name = aVar3.Avy.readString();
                    return 0;
                case 2:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dVar = new d();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.pey.add(dVar);
                    }
                    return 0;
                case 3:
                    cVar.pez = aVar3.Avy.ry();
                    return 0;
                case 4:
                    cVar.peA = aVar3.Avy.ry();
                    return 0;
                case 5:
                    cVar.peB = aVar3.Avy.ry();
                    return 0;
                case 6:
                    cVar.peC.add(aVar3.Avy.readString());
                    return 0;
                case 7:
                    cVar.hef = aVar3.Avy.readString();
                    return 0;
                case 8:
                    cVar.peD = aVar3.Avy.readString();
                    return 0;
                case 9:
                    cVar.peE.add(aVar3.Avy.readString());
                    return 0;
                case 10:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dVar = new b();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.peF.add(dVar);
                    }
                    return 0;
                case 11:
                    cVar.peG.add(aVar3.Avy.readString());
                    return 0;
                case 12:
                    cVar.peH = aVar3.Avy.ry();
                    return 0;
                case 13:
                    cVar.peI = aVar3.Avy.ry();
                    return 0;
                case 14:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dVar = new m();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.peJ.add(dVar);
                    }
                    return 0;
                case 15:
                    cVar.version = aVar3.Avy.ry();
                    return 0;
                case 16:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dVar = new a();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.peK.add(dVar);
                    }
                    return 0;
                case 17:
                    cVar.paz = aVar3.Avy.readString();
                    return 0;
                case 18:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        dVar = new k();
                        aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.peL = dVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
