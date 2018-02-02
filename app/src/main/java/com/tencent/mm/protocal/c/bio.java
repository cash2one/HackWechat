package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class bio extends a {
    public String wLZ;
    public String wMa;
    public String wMb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wLZ != null) {
                aVar.g(1, this.wLZ);
            }
            if (this.wMa != null) {
                aVar.g(2, this.wMa);
            }
            if (this.wMb == null) {
                return 0;
            }
            aVar.g(3, this.wMb);
            return 0;
        } else if (i == 1) {
            if (this.wLZ != null) {
                r0 = e.a.a.b.b.a.h(1, this.wLZ) + 0;
            } else {
                r0 = 0;
            }
            if (this.wMa != null) {
                r0 += e.a.a.b.b.a.h(2, this.wMa);
            }
            if (this.wMb != null) {
                r0 += e.a.a.b.b.a.h(3, this.wMb);
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
            bio com_tencent_mm_protocal_c_bio = (bio) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bio.wLZ = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bio.wMa = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bio.wMb = aVar3.Avy.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
