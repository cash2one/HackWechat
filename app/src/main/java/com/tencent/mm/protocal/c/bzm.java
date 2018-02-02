package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class bzm extends a {
    public int vEe;
    public String wYG;
    public boolean wZk;
    public String weY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYG == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.weY == null) {
                throw new b("Not all required fields were included: Text");
            } else {
                if (this.wYG != null) {
                    aVar.g(1, this.wYG);
                }
                if (this.weY != null) {
                    aVar.g(2, this.weY);
                }
                aVar.al(3, this.wZk);
                aVar.fU(4, this.vEe);
                return 0;
            }
        } else if (i == 1) {
            if (this.wYG != null) {
                r0 = e.a.a.b.b.a.h(1, this.wYG) + 0;
            } else {
                r0 = 0;
            }
            if (this.weY != null) {
                r0 += e.a.a.b.b.a.h(2, this.weY);
            }
            return (r0 + (e.a.a.b.b.a.dX(3) + 1)) + e.a.a.a.fR(4, this.vEe);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wYG == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.weY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Text");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzm com_tencent_mm_protocal_c_bzm = (bzm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bzm.wYG = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bzm.weY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bzm.wZk = aVar3.cJC();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bzm.vEe = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
