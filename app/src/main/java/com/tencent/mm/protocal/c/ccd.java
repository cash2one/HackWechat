package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class ccd extends a {
    public String hbH;
    public String title;
    public int xaW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hbH == null) {
                throw new b("Not all required fields were included: rankid");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else {
                if (this.hbH != null) {
                    aVar.g(1, this.hbH);
                }
                if (this.title != null) {
                    aVar.g(2, this.title);
                }
                aVar.fU(3, this.xaW);
                return 0;
            }
        } else if (i == 1) {
            if (this.hbH != null) {
                r0 = e.a.a.b.b.a.h(1, this.hbH) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += e.a.a.b.b.a.h(2, this.title);
            }
            return r0 + e.a.a.a.fR(3, this.xaW);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.hbH == null) {
                throw new b("Not all required fields were included: rankid");
            } else if (this.title != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: title");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccd com_tencent_mm_protocal_c_ccd = (ccd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ccd.hbH = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ccd.title = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ccd.xaW = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
