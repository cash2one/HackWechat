package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import java.util.LinkedList;

public final class nz extends a {
    public int ktS;
    public int lOd;
    public LinkedList<ank> ngS = new LinkedList();
    public int vLa;
    public String vOf;
    public String vOg;
    public String vOh;
    public String vOi;
    public String vOj;
    public int vWK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.lOd);
            if (this.vOh != null) {
                aVar.g(7, this.vOh);
            }
            aVar.fU(2, this.vLa);
            aVar.fU(3, this.vWK);
            aVar.d(4, 8, this.ngS);
            if (this.vOf != null) {
                aVar.g(5, this.vOf);
            }
            if (this.vOg != null) {
                aVar.g(6, this.vOg);
            }
            if (this.vOi != null) {
                aVar.g(8, this.vOi);
            }
            if (this.vOj != null) {
                aVar.g(9, this.vOj);
            }
            aVar.fU(10, this.ktS);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.lOd) + 0;
            if (this.vOh != null) {
                r0 += e.a.a.b.b.a.h(7, this.vOh);
            }
            r0 = ((r0 + e.a.a.a.fR(2, this.vLa)) + e.a.a.a.fR(3, this.vWK)) + e.a.a.a.c(4, 8, this.ngS);
            if (this.vOf != null) {
                r0 += e.a.a.b.b.a.h(5, this.vOf);
            }
            if (this.vOg != null) {
                r0 += e.a.a.b.b.a.h(6, this.vOg);
            }
            if (this.vOi != null) {
                r0 += e.a.a.b.b.a.h(8, this.vOi);
            }
            if (this.vOj != null) {
                r0 += e.a.a.b.b.a.h(9, this.vOj);
            }
            return r0 + e.a.a.a.fR(10, this.ktS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ngS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nz nzVar = (nz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nzVar.lOd = aVar3.Avy.ry();
                    return 0;
                case 2:
                    nzVar.vLa = aVar3.Avy.ry();
                    return 0;
                case 3:
                    nzVar.vWK = aVar3.Avy.ry();
                    return 0;
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_ank = new ank();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_ank.a(aVar4, com_tencent_mm_protocal_c_ank, a.a(aVar4))) {
                        }
                        nzVar.ngS.add(com_tencent_mm_protocal_c_ank);
                    }
                    return 0;
                case 5:
                    nzVar.vOf = aVar3.Avy.readString();
                    return 0;
                case 6:
                    nzVar.vOg = aVar3.Avy.readString();
                    return 0;
                case 7:
                    nzVar.vOh = aVar3.Avy.readString();
                    return 0;
                case 8:
                    nzVar.vOi = aVar3.Avy.readString();
                    return 0;
                case 9:
                    nzVar.vOj = aVar3.Avy.readString();
                    return 0;
                case 10:
                    nzVar.ktS = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
