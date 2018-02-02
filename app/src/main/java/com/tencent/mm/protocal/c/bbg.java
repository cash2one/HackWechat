package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bbg extends a {
    public String odv;
    public String odw;
    public String odx;
    public String ody;
    public int vDQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fU(1, this.vDQ);
            if (this.odv != null) {
                aVar.g(2, this.odv);
            }
            if (this.odw != null) {
                aVar.g(3, this.odw);
            }
            if (this.odx != null) {
                aVar.g(4, this.odx);
            }
            if (this.ody != null) {
                aVar.g(5, this.ody);
            }
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.vDQ) + 0;
            if (this.odv != null) {
                r0 += e.a.a.b.b.a.h(2, this.odv);
            }
            if (this.odw != null) {
                r0 += e.a.a.b.b.a.h(3, this.odw);
            }
            if (this.odx != null) {
                r0 += e.a.a.b.b.a.h(4, this.odx);
            }
            if (this.ody != null) {
                return r0 + e.a.a.b.b.a.h(5, this.ody);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bbg com_tencent_mm_protocal_c_bbg = (bbg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bbg.vDQ = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbg.odv = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbg.odw = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbg.odx = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbg.ody = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
