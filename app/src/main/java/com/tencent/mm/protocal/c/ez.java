package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class ez extends a {
    public String nBM;
    public String oZz;
    public String pHq;
    public int pHr;
    public int pHs;
    public String pHt;
    public String pHu;
    public String pHv;
    public LinkedList<sw> vKM = new LinkedList();
    public String vKN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.oZz != null) {
                aVar.g(1, this.oZz);
            }
            if (this.nBM != null) {
                aVar.g(2, this.nBM);
            }
            if (this.pHq != null) {
                aVar.g(3, this.pHq);
            }
            aVar.fU(4, this.pHr);
            aVar.fU(5, this.pHs);
            aVar.d(6, 8, this.vKM);
            if (this.pHt != null) {
                aVar.g(7, this.pHt);
            }
            if (this.pHu != null) {
                aVar.g(8, this.pHu);
            }
            if (this.pHv != null) {
                aVar.g(9, this.pHv);
            }
            if (this.vKN == null) {
                return 0;
            }
            aVar.g(10, this.vKN);
            return 0;
        } else if (i == 1) {
            if (this.oZz != null) {
                r0 = e.a.a.b.b.a.h(1, this.oZz) + 0;
            } else {
                r0 = 0;
            }
            if (this.nBM != null) {
                r0 += e.a.a.b.b.a.h(2, this.nBM);
            }
            if (this.pHq != null) {
                r0 += e.a.a.b.b.a.h(3, this.pHq);
            }
            r0 = ((r0 + e.a.a.a.fR(4, this.pHr)) + e.a.a.a.fR(5, this.pHs)) + e.a.a.a.c(6, 8, this.vKM);
            if (this.pHt != null) {
                r0 += e.a.a.b.b.a.h(7, this.pHt);
            }
            if (this.pHu != null) {
                r0 += e.a.a.b.b.a.h(8, this.pHu);
            }
            if (this.pHv != null) {
                r0 += e.a.a.b.b.a.h(9, this.pHv);
            }
            if (this.vKN != null) {
                r0 += e.a.a.b.b.a.h(10, this.vKN);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vKM.clear();
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
            ez ezVar = (ez) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ezVar.oZz = aVar3.Avy.readString();
                    return 0;
                case 2:
                    ezVar.nBM = aVar3.Avy.readString();
                    return 0;
                case 3:
                    ezVar.pHq = aVar3.Avy.readString();
                    return 0;
                case 4:
                    ezVar.pHr = aVar3.Avy.ry();
                    return 0;
                case 5:
                    ezVar.pHs = aVar3.Avy.ry();
                    return 0;
                case 6:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a swVar = new sw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = swVar.a(aVar4, swVar, a.a(aVar4))) {
                        }
                        ezVar.vKM.add(swVar);
                    }
                    return 0;
                case 7:
                    ezVar.pHt = aVar3.Avy.readString();
                    return 0;
                case 8:
                    ezVar.pHu = aVar3.Avy.readString();
                    return 0;
                case 9:
                    ezVar.pHv = aVar3.Avy.readString();
                    return 0;
                case 10:
                    ezVar.vKN = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
