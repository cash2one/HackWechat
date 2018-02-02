package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class v extends a {
    public String ID;
    public b ksB;
    public int ktL;
    public int ktM;
    public int ktN;
    public int ktO;
    public int ktP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new e.a.a.b("Not all required fields were included: ID");
            }
            aVar.fU(1, this.ktL);
            if (this.ID != null) {
                aVar.g(2, this.ID);
            }
            if (this.ksB != null) {
                aVar.b(3, this.ksB);
            }
            aVar.fU(4, this.ktM);
            aVar.fU(5, this.ktN);
            aVar.fU(6, this.ktO);
            aVar.fU(7, this.ktP);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.ktL) + 0;
            if (this.ID != null) {
                r0 += e.a.a.b.b.a.h(2, this.ID);
            }
            if (this.ksB != null) {
                r0 += e.a.a.a.a(3, this.ksB);
            }
            return (((r0 + e.a.a.a.fR(4, this.ktM)) + e.a.a.a.fR(5, this.ktN)) + e.a.a.a.fR(6, this.ktO)) + e.a.a.a.fR(7, this.ktP);
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
            throw new e.a.a.b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vVar.ktL = aVar3.Avy.ry();
                    return 0;
                case 2:
                    vVar.ID = aVar3.Avy.readString();
                    return 0;
                case 3:
                    vVar.ksB = aVar3.cJD();
                    return 0;
                case 4:
                    vVar.ktM = aVar3.Avy.ry();
                    return 0;
                case 5:
                    vVar.ktN = aVar3.Avy.ry();
                    return 0;
                case 6:
                    vVar.ktO = aVar3.Avy.ry();
                    return 0;
                case 7:
                    vVar.ktP = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
