package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class gv extends bcv {
    public int vJL;
    public int vLT;
    public String vLU;
    public String vLV;
    public String vLW;
    public String vLX;
    public String vLY;
    public String vLZ;
    public String vMa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.fU(2, this.vJL);
            aVar.fU(3, this.vLT);
            if (this.vLU != null) {
                aVar.g(4, this.vLU);
            }
            if (this.vLV != null) {
                aVar.g(5, this.vLV);
            }
            if (this.vLW != null) {
                aVar.g(6, this.vLW);
            }
            if (this.vLX != null) {
                aVar.g(7, this.vLX);
            }
            if (this.vLY != null) {
                aVar.g(8, this.vLY);
            }
            if (this.vLZ != null) {
                aVar.g(9, this.vLZ);
            }
            if (this.vMa == null) {
                return 0;
            }
            aVar.g(10, this.vMa);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + e.a.a.a.fR(2, this.vJL)) + e.a.a.a.fR(3, this.vLT);
            if (this.vLU != null) {
                r0 += e.a.a.b.b.a.h(4, this.vLU);
            }
            if (this.vLV != null) {
                r0 += e.a.a.b.b.a.h(5, this.vLV);
            }
            if (this.vLW != null) {
                r0 += e.a.a.b.b.a.h(6, this.vLW);
            }
            if (this.vLX != null) {
                r0 += e.a.a.b.b.a.h(7, this.vLX);
            }
            if (this.vLY != null) {
                r0 += e.a.a.b.b.a.h(8, this.vLY);
            }
            if (this.vLZ != null) {
                r0 += e.a.a.b.b.a.h(9, this.vLZ);
            }
            if (this.vMa != null) {
                r0 += e.a.a.b.b.a.h(10, this.vMa);
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
            gv gvVar = (gv) objArr[1];
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
                        gvVar.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    gvVar.vJL = aVar3.Avy.ry();
                    return 0;
                case 3:
                    gvVar.vLT = aVar3.Avy.ry();
                    return 0;
                case 4:
                    gvVar.vLU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    gvVar.vLV = aVar3.Avy.readString();
                    return 0;
                case 6:
                    gvVar.vLW = aVar3.Avy.readString();
                    return 0;
                case 7:
                    gvVar.vLX = aVar3.Avy.readString();
                    return 0;
                case 8:
                    gvVar.vLY = aVar3.Avy.readString();
                    return 0;
                case 9:
                    gvVar.vLZ = aVar3.Avy.readString();
                    return 0;
                case 10:
                    gvVar.vMa = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
