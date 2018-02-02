package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;

public final class bgr extends a {
    public b wKV;
    public b wuv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wKV == null) {
                throw new e.a.a.b("Not all required fields were included: Name");
            } else if (this.wuv == null) {
                throw new e.a.a.b("Not all required fields were included: Value");
            } else {
                if (this.wKV != null) {
                    aVar.b(1, this.wKV);
                }
                if (this.wuv == null) {
                    return 0;
                }
                aVar.b(2, this.wuv);
                return 0;
            }
        } else if (i == 1) {
            if (this.wKV != null) {
                r0 = e.a.a.a.a(1, this.wKV) + 0;
            } else {
                r0 = 0;
            }
            if (this.wuv != null) {
                r0 += e.a.a.a.a(2, this.wuv);
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wKV == null) {
                throw new e.a.a.b("Not all required fields were included: Name");
            } else if (this.wuv != null) {
                return 0;
            } else {
                throw new e.a.a.b("Not all required fields were included: Value");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgr com_tencent_mm_protocal_c_bgr = (bgr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgr.wKV = aVar3.cJD();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgr.wuv = aVar3.cJD();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
