package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class nv extends bcv {
    public String nko;
    public String nkp;
    public int rYW;
    public int vGW;
    public long vHe;
    public int vIB;
    public String vWC;
    public bsx vWD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            if (this.vWC != null) {
                aVar.g(2, this.vWC);
            }
            aVar.fU(3, this.vIB);
            aVar.fU(4, this.vGW);
            if (this.vWD != null) {
                aVar.fW(5, this.vWD.bke());
                this.vWD.a(aVar);
            }
            aVar.S(6, this.vHe);
            aVar.fU(7, this.rYW);
            if (this.nkp != null) {
                aVar.g(8, this.nkp);
            }
            if (this.nko == null) {
                return 0;
            }
            aVar.g(9, this.nko);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            if (this.vWC != null) {
                r0 += e.a.a.b.b.a.h(2, this.vWC);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.vIB)) + e.a.a.a.fR(4, this.vGW);
            if (this.vWD != null) {
                r0 += e.a.a.a.fT(5, this.vWD.bke());
            }
            r0 = (r0 + e.a.a.a.R(6, this.vHe)) + e.a.a.a.fR(7, this.rYW);
            if (this.nkp != null) {
                r0 += e.a.a.b.b.a.h(8, this.nkp);
            }
            if (this.nko != null) {
                r0 += e.a.a.b.b.a.h(9, this.nko);
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
            nv nvVar = (nv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Jl;
            int size;
            byte[] bArr;
            com.tencent.mm.bq.a fdVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new fd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        nvVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    nvVar.vWC = aVar3.Avy.readString();
                    return 0;
                case 3:
                    nvVar.vIB = aVar3.Avy.ry();
                    return 0;
                case 4:
                    nvVar.vGW = aVar3.Avy.ry();
                    return 0;
                case 5:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bsx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        nvVar.vWD = fdVar;
                    }
                    return 0;
                case 6:
                    nvVar.vHe = aVar3.Avy.rz();
                    return 0;
                case 7:
                    nvVar.rYW = aVar3.Avy.ry();
                    return 0;
                case 8:
                    nvVar.nkp = aVar3.Avy.readString();
                    return 0;
                case 9:
                    nvVar.nko = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
