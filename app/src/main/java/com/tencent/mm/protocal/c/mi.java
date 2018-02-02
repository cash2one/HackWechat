package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class mi extends bcv {
    public String hJu;
    public String nko;
    public String nkp;
    public int vIE;
    public String vQA;
    public long vVa;
    public String vVb;
    public String vVc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.nkp != null) {
                aVar.g(2, this.nkp);
            }
            if (this.nko != null) {
                aVar.g(3, this.nko);
            }
            aVar.S(4, this.vVa);
            if (this.vQA != null) {
                aVar.g(5, this.vQA);
            }
            if (this.vVb != null) {
                aVar.g(6, this.vVb);
            }
            aVar.fU(7, this.vIE);
            if (this.vVc != null) {
                aVar.g(8, this.vVc);
            }
            if (this.hJu == null) {
                return 0;
            }
            aVar.g(9, this.hJu);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(2, this.nkp);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(3, this.nko);
            }
            r0 += e.a.a.a.R(4, this.vVa);
            if (this.vQA != null) {
                r0 += e.a.a.b.b.a.h(5, this.vQA);
            }
            if (this.vVb != null) {
                r0 += e.a.a.b.b.a.h(6, this.vVb);
            }
            r0 += e.a.a.a.fR(7, this.vIE);
            if (this.vVc != null) {
                r0 += e.a.a.b.b.a.h(8, this.vVc);
            }
            if (this.hJu != null) {
                r0 += e.a.a.b.b.a.h(9, this.hJu);
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
            mi miVar = (mi) objArr[1];
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
                        miVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    miVar.nkp = aVar3.Avy.readString();
                    return 0;
                case 3:
                    miVar.nko = aVar3.Avy.readString();
                    return 0;
                case 4:
                    miVar.vVa = aVar3.Avy.rz();
                    return 0;
                case 5:
                    miVar.vQA = aVar3.Avy.readString();
                    return 0;
                case 6:
                    miVar.vVb = aVar3.Avy.readString();
                    return 0;
                case 7:
                    miVar.vIE = aVar3.Avy.ry();
                    return 0;
                case 8:
                    miVar.vVc = aVar3.Avy.readString();
                    return 0;
                case 9:
                    miVar.hJu = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
