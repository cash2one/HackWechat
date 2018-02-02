package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class hy extends bcv {
    public int rYW;
    public int vLj;
    public int vME;
    public int vNT;
    public bdn vNU;
    public int vNV;
    public int vNW;
    public int vNX;
    public int vNY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vNU == null) {
                throw new b("Not all required fields were included: ImageBuffer");
            }
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vNT);
            if (this.vNU != null) {
                aVar.fW(3, this.vNU.bke());
                this.vNU.a(aVar);
            }
            aVar.fU(4, this.vNV);
            aVar.fU(5, this.vNW);
            aVar.fU(6, this.vLj);
            aVar.fU(7, this.vNX);
            aVar.fU(8, this.vME);
            aVar.fU(9, this.vNY);
            aVar.fU(10, this.rYW);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 += e.a.a.a.fR(2, this.vNT);
            if (this.vNU != null) {
                r0 += e.a.a.a.fT(3, this.vNU.bke());
            }
            return ((((((r0 + e.a.a.a.fR(4, this.vNV)) + e.a.a.a.fR(5, this.vNW)) + e.a.a.a.fR(6, this.vLj)) + e.a.a.a.fR(7, this.vNX)) + e.a.a.a.fR(8, this.vME)) + e.a.a.a.fR(9, this.vNY)) + e.a.a.a.fR(10, this.rYW);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = bcv.a(aVar2); r0 > 0; r0 = bcv.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vNU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImageBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hy hyVar = (hy) objArr[1];
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
                        hyVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    hyVar.vNT = aVar3.Avy.ry();
                    return 0;
                case 3:
                    Jl = aVar3.Jl(intValue);
                    size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Jl.get(intValue);
                        fdVar = new bdn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        hyVar.vNU = fdVar;
                    }
                    return 0;
                case 4:
                    hyVar.vNV = aVar3.Avy.ry();
                    return 0;
                case 5:
                    hyVar.vNW = aVar3.Avy.ry();
                    return 0;
                case 6:
                    hyVar.vLj = aVar3.Avy.ry();
                    return 0;
                case 7:
                    hyVar.vNX = aVar3.Avy.ry();
                    return 0;
                case 8:
                    hyVar.vME = aVar3.Avy.ry();
                    return 0;
                case 9:
                    hyVar.vNY = aVar3.Avy.ry();
                    return 0;
                case 10:
                    hyVar.rYW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
