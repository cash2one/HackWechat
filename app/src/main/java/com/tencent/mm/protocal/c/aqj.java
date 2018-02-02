package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aqj extends a {
    public String bssid;
    public String fpz;
    public int ftq;
    public int mCv;
    public String ssid;
    public int wxe;
    public String wxf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ssid != null) {
                aVar.g(1, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(2, this.bssid);
            }
            aVar.fU(3, this.ftq);
            aVar.fU(4, this.wxe);
            if (this.wxf != null) {
                aVar.g(5, this.wxf);
            }
            if (this.fpz != null) {
                aVar.g(6, this.fpz);
            }
            aVar.fU(7, this.mCv);
            return 0;
        } else if (i == 1) {
            if (this.ssid != null) {
                r0 = e.a.a.b.b.a.h(1, this.ssid) + 0;
            } else {
                r0 = 0;
            }
            if (this.bssid != null) {
                r0 += e.a.a.b.b.a.h(2, this.bssid);
            }
            r0 = (r0 + e.a.a.a.fR(3, this.ftq)) + e.a.a.a.fR(4, this.wxe);
            if (this.wxf != null) {
                r0 += e.a.a.b.b.a.h(5, this.wxf);
            }
            if (this.fpz != null) {
                r0 += e.a.a.b.b.a.h(6, this.fpz);
            }
            return r0 + e.a.a.a.fR(7, this.mCv);
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
            aqj com_tencent_mm_protocal_c_aqj = (aqj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqj.ssid = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqj.bssid = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqj.ftq = aVar3.Avy.ry();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqj.wxe = aVar3.Avy.ry();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqj.wxf = aVar3.Avy.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqj.fpz = aVar3.Avy.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqj.mCv = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
