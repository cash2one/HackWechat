package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class aqy extends a {
    public String fon;
    public String pbP;
    public int wgQ;
    public String wgR;
    public int wyO;
    public int wyP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.pbP == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else {
                aVar.fU(1, this.wyO);
                if (this.fon != null) {
                    aVar.g(2, this.fon);
                }
                if (this.pbP != null) {
                    aVar.g(3, this.pbP);
                }
                aVar.fU(4, this.wgQ);
                if (this.wgR != null) {
                    aVar.g(5, this.wgR);
                }
                aVar.fU(6, this.wyP);
                return 0;
            }
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.wyO) + 0;
            if (this.fon != null) {
                r0 += e.a.a.b.b.a.h(2, this.fon);
            }
            if (this.pbP != null) {
                r0 += e.a.a.b.b.a.h(3, this.pbP);
            }
            r0 += e.a.a.a.fR(4, this.wgQ);
            if (this.wgR != null) {
                r0 += e.a.a.b.b.a.h(5, this.wgR);
            }
            return r0 + e.a.a.a.fR(6, this.wyP);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fon == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.pbP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqy com_tencent_mm_protocal_c_aqy = (aqy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqy.wyO = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqy.fon = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqy.pbP = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqy.wgQ = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqy.wgR = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqy.wyP = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
