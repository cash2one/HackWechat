package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class ri extends bcv {
    public String ksU;
    public int ktN;
    public String ngo;
    public int vHT;
    public long vHe;
    public int vIB;
    public int vIC;
    public int vID;
    public String vZq;
    public String vZr;
    public int vZs;
    public int vZt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.ngo != null) {
                aVar.g(2, this.ngo);
            }
            aVar.fU(3, this.vHT);
            if (this.vZq != null) {
                aVar.g(4, this.vZq);
            }
            if (this.ksU != null) {
                aVar.g(5, this.ksU);
            }
            aVar.fU(6, this.vIB);
            aVar.fU(7, this.vIC);
            aVar.fU(8, this.vID);
            if (this.vZr != null) {
                aVar.g(9, this.vZr);
            }
            aVar.fU(10, this.vZs);
            aVar.fU(11, this.ktN);
            aVar.fU(12, this.vZt);
            aVar.S(13, this.vHe);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ngo != null) {
                r0 += e.a.a.b.b.a.h(2, this.ngo);
            }
            r0 += e.a.a.a.fR(3, this.vHT);
            if (this.vZq != null) {
                r0 += e.a.a.b.b.a.h(4, this.vZq);
            }
            if (this.ksU != null) {
                r0 += e.a.a.b.b.a.h(5, this.ksU);
            }
            r0 = ((r0 + e.a.a.a.fR(6, this.vIB)) + e.a.a.a.fR(7, this.vIC)) + e.a.a.a.fR(8, this.vID);
            if (this.vZr != null) {
                r0 += e.a.a.b.b.a.h(9, this.vZr);
            }
            return (((r0 + e.a.a.a.fR(10, this.vZs)) + e.a.a.a.fR(11, this.ktN)) + e.a.a.a.fR(12, this.vZt)) + e.a.a.a.R(13, this.vHe);
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
            ri riVar = (ri) objArr[1];
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
                        riVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    riVar.ngo = aVar3.Avy.readString();
                    return 0;
                case 3:
                    riVar.vHT = aVar3.Avy.ry();
                    return 0;
                case 4:
                    riVar.vZq = aVar3.Avy.readString();
                    return 0;
                case 5:
                    riVar.ksU = aVar3.Avy.readString();
                    return 0;
                case 6:
                    riVar.vIB = aVar3.Avy.ry();
                    return 0;
                case 7:
                    riVar.vIC = aVar3.Avy.ry();
                    return 0;
                case 8:
                    riVar.vID = aVar3.Avy.ry();
                    return 0;
                case 9:
                    riVar.vZr = aVar3.Avy.readString();
                    return 0;
                case 10:
                    riVar.vZs = aVar3.Avy.ry();
                    return 0;
                case 11:
                    riVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 12:
                    riVar.vZt = aVar3.Avy.ry();
                    return 0;
                case 13:
                    riVar.vHe = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
