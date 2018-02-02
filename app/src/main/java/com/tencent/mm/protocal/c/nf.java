package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class nf extends bcv {
    public String fon;
    public String ngo;
    public int rYW;
    public String vVZ;
    public String vWa;
    public String vWb;
    public String vWc;
    public String vWd;
    public String vWe;
    public String vWf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vVZ != null) {
                aVar.g(2, this.vVZ);
            }
            if (this.fon != null) {
                aVar.g(3, this.fon);
            }
            if (this.vWa != null) {
                aVar.g(4, this.vWa);
            }
            if (this.vWb != null) {
                aVar.g(5, this.vWb);
            }
            if (this.vWc != null) {
                aVar.g(6, this.vWc);
            }
            if (this.vWd != null) {
                aVar.g(7, this.vWd);
            }
            if (this.vWe != null) {
                aVar.g(8, this.vWe);
            }
            if (this.ngo != null) {
                aVar.g(9, this.ngo);
            }
            aVar.fU(10, this.rYW);
            if (this.vWf == null) {
                return 0;
            }
            aVar.g(11, this.vWf);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vVZ != null) {
                r0 += e.a.a.b.b.a.h(2, this.vVZ);
            }
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(3, this.fon);
            }
            if (this.vWa != null) {
                r0 += e.a.a.b.b.a.h(4, this.vWa);
            }
            if (this.vWb != null) {
                r0 += e.a.a.b.b.a.h(5, this.vWb);
            }
            if (this.vWc != null) {
                r0 += e.a.a.b.b.a.h(6, this.vWc);
            }
            if (this.vWd != null) {
                r0 += e.a.a.b.b.a.h(7, this.vWd);
            }
            if (this.vWe != null) {
                r0 += e.a.a.b.b.a.h(8, this.vWe);
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(9, this.ngo);
            }
            r0 += e.a.a.a.fR(10, this.rYW);
            if (this.vWf != null) {
                r0 += e.a.a.b.b.a.h(11, this.vWf);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            nf nfVar = (nf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        nfVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    nfVar.vVZ = aVar3.Avy.readString();
                    return 0;
                case 3:
                    nfVar.fon = aVar3.Avy.readString();
                    return 0;
                case 4:
                    nfVar.vWa = aVar3.Avy.readString();
                    return 0;
                case 5:
                    nfVar.vWb = aVar3.Avy.readString();
                    return 0;
                case 6:
                    nfVar.vWc = aVar3.Avy.readString();
                    return 0;
                case 7:
                    nfVar.vWd = aVar3.Avy.readString();
                    return 0;
                case 8:
                    nfVar.vWe = aVar3.Avy.readString();
                    return 0;
                case 9:
                    nfVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 10:
                    nfVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 11:
                    nfVar.vWf = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
