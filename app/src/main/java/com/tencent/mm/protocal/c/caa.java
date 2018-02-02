package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;
import e.a.a.b;

public final class caa extends a {
    public String vNd;
    public String vZL;
    public int wZI;
    public int wZJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vZL == null) {
                throw new b("Not all required fields were included: Md5");
            } else if (this.vNd == null) {
                throw new b("Not all required fields were included: DownloadUrl");
            } else {
                if (this.vZL != null) {
                    aVar.g(1, this.vZL);
                }
                if (this.vNd != null) {
                    aVar.g(2, this.vNd);
                }
                aVar.fU(3, this.wZI);
                aVar.fU(4, this.wZJ);
                return 0;
            }
        } else if (i == 1) {
            if (this.vZL != null) {
                r0 = e.a.a.b.b.a.h(1, this.vZL) + 0;
            } else {
                r0 = 0;
            }
            if (this.vNd != null) {
                r0 += e.a.a.b.b.a.h(2, this.vNd);
            }
            return (r0 + e.a.a.a.fR(3, this.wZI)) + e.a.a.a.fR(4, this.wZJ);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cJE();
                }
            }
            if (this.vZL == null) {
                throw new b("Not all required fields were included: Md5");
            } else if (this.vNd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            caa com_tencent_mm_protocal_c_caa = (caa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_caa.vZL = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_caa.vNd = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_caa.wZI = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_caa.wZJ = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
