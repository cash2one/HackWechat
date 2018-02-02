package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class aqz extends a {
    public String fyY;
    public int type;
    public String url;
    public String wyQ;
    public String wyR;
    public String wyS;
    public int wyT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fyY == null) {
                throw new b("Not all required fields were included: wording");
            }
            aVar.fU(1, this.type);
            if (this.fyY != null) {
                aVar.g(2, this.fyY);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            if (this.wyQ != null) {
                aVar.g(4, this.wyQ);
            }
            if (this.wyR != null) {
                aVar.g(5, this.wyR);
            }
            if (this.wyS != null) {
                aVar.g(6, this.wyS);
            }
            aVar.fU(7, this.wyT);
            return 0;
        } else if (i == 1) {
            r0 = e.a.a.a.fR(1, this.type) + 0;
            if (this.fyY != null) {
                r0 += e.a.a.b.b.a.h(2, this.fyY);
            }
            if (this.url != null) {
                r0 += e.a.a.b.b.a.h(3, this.url);
            }
            if (this.wyQ != null) {
                r0 += e.a.a.b.b.a.h(4, this.wyQ);
            }
            if (this.wyR != null) {
                r0 += e.a.a.b.b.a.h(5, this.wyR);
            }
            if (this.wyS != null) {
                r0 += e.a.a.b.b.a.h(6, this.wyS);
            }
            return r0 + e.a.a.a.fR(7, this.wyT);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.fyY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: wording");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aqz com_tencent_mm_protocal_c_aqz = (aqz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqz.type = aVar3.Avy.ry();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqz.fyY = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqz.url = aVar3.Avy.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqz.wyQ = aVar3.Avy.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqz.wyR = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqz.wyS = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqz.wyT = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
