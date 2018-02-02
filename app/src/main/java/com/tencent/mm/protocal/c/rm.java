package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class rm extends bcv {
    public int vGW;
    public String vHU;
    public long vHe;
    public int vNW;
    public String vYJ;
    public int vZw;
    public long vZx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.fU(1, this.vGW);
            aVar.fU(2, this.vNW);
            aVar.fU(3, this.vZw);
            if (this.vHU != null) {
                aVar.g(4, this.vHU);
            }
            if (this.wIV != null) {
                aVar.fW(5, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.S(6, this.vHe);
            if (this.vYJ != null) {
                aVar.g(7, this.vYJ);
            }
            aVar.S(8, this.vZx);
            return 0;
        } else if (i == 1) {
            r0 = ((e.a.a.a.fR(1, this.vGW) + 0) + e.a.a.a.fR(2, this.vNW)) + e.a.a.a.fR(3, this.vZw);
            if (this.vHU != null) {
                r0 += e.a.a.b.b.a.h(4, this.vHU);
            }
            if (this.wIV != null) {
                r0 += e.a.a.a.fT(5, this.wIV.bke());
            }
            r0 += e.a.a.a.R(6, this.vHe);
            if (this.vYJ != null) {
                r0 += e.a.a.b.b.a.h(7, this.vYJ);
            }
            return r0 + e.a.a.a.R(8, this.vZx);
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
            rm rmVar = (rm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rmVar.vGW = aVar3.Avy.ry();
                    return 0;
                case 2:
                    rmVar.vNW = aVar3.Avy.ry();
                    return 0;
                case 3:
                    rmVar.vZw = aVar3.Avy.ry();
                    return 0;
                case 4:
                    rmVar.vHU = aVar3.Avy.readString();
                    return 0;
                case 5:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        com.tencent.mm.bq.a fdVar = new fd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fdVar.a(aVar4, fdVar, bcv.a(aVar4))) {
                        }
                        rmVar.wIV = fdVar;
                    }
                    return 0;
                case 6:
                    rmVar.vHe = aVar3.Avy.rz();
                    return 0;
                case 7:
                    rmVar.vYJ = aVar3.Avy.readString();
                    return 0;
                case 8:
                    rmVar.vZx = aVar3.Avy.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
