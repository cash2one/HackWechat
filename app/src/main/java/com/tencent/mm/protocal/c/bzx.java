package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bzx extends a {
    public caa wZB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZB == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else if (this.wZB == null) {
                return 0;
            } else {
                aVar.fW(4, this.wZB.bke());
                this.wZB.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.wZB != null) {
                r0 = e.a.a.a.fT(4, this.wZB.bke()) + 0;
            } else {
                r0 = 0;
            }
            return r0;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.wZB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadInfo");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzx com_tencent_mm_protocal_c_bzx = (bzx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    LinkedList Jl = aVar3.Jl(intValue);
                    int size = Jl.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Jl.get(intValue);
                        a com_tencent_mm_protocal_c_caa = new caa();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_caa.a(aVar4, com_tencent_mm_protocal_c_caa, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bzx.wZB = com_tencent_mm_protocal_c_caa;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
