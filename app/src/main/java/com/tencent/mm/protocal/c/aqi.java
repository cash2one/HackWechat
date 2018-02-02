package com.tencent.mm.protocal.c;

import com.tencent.mm.bq.a;

public final class aqi extends a {
    public String bssid;
    public int ftq;
    public String ssid;

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
            return r0 + e.a.a.a.fR(3, this.ftq);
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
            aqi com_tencent_mm_protocal_c_aqi = (aqi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqi.ssid = aVar3.Avy.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqi.bssid = aVar3.Avy.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqi.ftq = aVar3.Avy.ry();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
