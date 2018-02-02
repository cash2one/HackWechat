package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String ID;
    public h ksC;
    public int ksD;
    public int ksE;
    public int ksF;
    public int ksG;
    public int ksH;
    public int ksI;
    public int ksJ;
    public int ksK;
    public int ksL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            if (this.ksC != null) {
                aVar.fW(2, this.ksC.bke());
                this.ksC.a(aVar);
            }
            aVar.fU(3, this.ksD);
            aVar.fU(4, this.ksE);
            aVar.fU(5, this.ksF);
            aVar.fU(6, this.ksG);
            aVar.fU(7, this.ksH);
            aVar.fU(8, this.ksI);
            aVar.fU(9, this.ksJ);
            aVar.fU(10, this.ksK);
            aVar.fU(11, this.ksL);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = e.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            if (this.ksC != null) {
                r0 += e.a.a.a.fT(2, this.ksC.bke());
            }
            return ((((((((r0 + e.a.a.a.fR(3, this.ksD)) + e.a.a.a.fR(4, this.ksE)) + e.a.a.a.fR(5, this.ksF)) + e.a.a.a.fR(6, this.ksG)) + e.a.a.a.fR(7, this.ksH)) + e.a.a.a.fR(8, this.ksI)) + e.a.a.a.fR(9, this.ksJ)) + e.a.a.a.fR(10, this.ksK)) + e.a.a.a.fR(11, this.ksL);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.ID = aVar3.Avy.readString();
                    return 0;
                case 2:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a hVar = new h();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        dVar.ksC = hVar;
                    }
                    return 0;
                case 3:
                    dVar.ksD = aVar3.Avy.ry();
                    return 0;
                case 4:
                    dVar.ksE = aVar3.Avy.ry();
                    return 0;
                case 5:
                    dVar.ksF = aVar3.Avy.ry();
                    return 0;
                case 6:
                    dVar.ksG = aVar3.Avy.ry();
                    return 0;
                case 7:
                    dVar.ksH = aVar3.Avy.ry();
                    return 0;
                case 8:
                    dVar.ksI = aVar3.Avy.ry();
                    return 0;
                case 9:
                    dVar.ksJ = aVar3.Avy.ry();
                    return 0;
                case 10:
                    dVar.ksK = aVar3.Avy.ry();
                    return 0;
                case 11:
                    dVar.ksL = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
