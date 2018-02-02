package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class hs extends bcv {
    public int rYW;
    public String vIR;
    public LinkedList<String> vNM = new LinkedList();
    public String vNN;
    public double vNO;
    public double vNP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vIR != null) {
                aVar.g(2, this.vIR);
            }
            aVar.d(3, 1, this.vNM);
            aVar.fU(4, this.rYW);
            if (this.vNN != null) {
                aVar.g(5, this.vNN);
            }
            aVar.b(6, this.vNO);
            aVar.b(7, this.vNP);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vIR != null) {
                r0 += e.a.a.b.b.a.h(2, this.vIR);
            }
            r0 = (r0 + e.a.a.a.c(3, 1, this.vNM)) + e.a.a.a.fR(4, this.rYW);
            if (this.vNN != null) {
                r0 += e.a.a.b.b.a.h(5, this.vNN);
            }
            return (r0 + (e.a.a.b.b.a.dX(6) + 8)) + (e.a.a.b.b.a.dX(7) + 8);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.vNM.clear();
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
            hs hsVar = (hs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        hsVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    hsVar.vIR = aVar3.Avy.readString();
                    return 0;
                case 3:
                    hsVar.vNM.add(aVar3.Avy.readString());
                    return 0;
                case 4:
                    hsVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 5:
                    hsVar.vNN = aVar3.Avy.readString();
                    return 0;
                case 6:
                    hsVar.vNO = aVar3.Avy.readDouble();
                    return 0;
                case 7:
                    hsVar.vNP = aVar3.Avy.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
