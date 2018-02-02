package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bcn extends bcv {
    public float fBc;
    public String fGU;
    public float fzt;
    public float wID;
    public b wIE;
    public boolean wIF;
    public boolean wIG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wIV != null) {
                aVar.fW(1, this.wIV.bke());
                this.wIV.a(aVar);
            }
            aVar.m(2, this.fBc);
            aVar.m(3, this.fzt);
            aVar.m(4, this.wID);
            if (this.wIE != null) {
                aVar.b(5, this.wIE);
            }
            if (this.fGU != null) {
                aVar.g(6, this.fGU);
            }
            aVar.al(7, this.wIF);
            aVar.al(8, this.wIG);
            return 0;
        } else if (i == 1) {
            if (this.wIV != null) {
                r0 = e.a.a.a.fT(1, this.wIV.bke()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + (e.a.a.b.b.a.dX(2) + 4)) + (e.a.a.b.b.a.dX(3) + 4)) + (e.a.a.b.b.a.dX(4) + 4);
            if (this.wIE != null) {
                r0 += e.a.a.a.a(5, this.wIE);
            }
            if (this.fGU != null) {
                r0 += e.a.a.b.b.a.h(6, this.fGU);
            }
            return (r0 + (e.a.a.b.b.a.dX(7) + 1)) + (e.a.a.b.b.a.dX(8) + 1);
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
            bcn com_tencent_mm_protocal_c_bcn = (bcn) objArr[1];
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
                        com_tencent_mm_protocal_c_bcn.wIV = fdVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcn.fBc = aVar3.Avy.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bcn.fzt = aVar3.Avy.readFloat();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bcn.wID = aVar3.Avy.readFloat();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bcn.wIE = aVar3.cJD();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcn.fGU = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcn.wIF = aVar3.cJC();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcn.wIG = aVar3.cJC();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
