package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class k extends ae implements e {
    private String lLR = null;
    private String lLS = null;
    private String lRh = null;
    private int lyE = -1;

    public k(String str, String str2, String str3, int i) {
        this.lLR = str;
        this.lRh = str2;
        this.lLS = str3;
        this.lyE = i;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ar.CG().b(1090, this);
    }

    public final boolean a(m mVar, d dVar) {
        x.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "excute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.lLR + ",deviceType=" + this.lRh + ",deviceId=" + this.lLS + ",reqType=" + this.lyE);
        ar.CG().a(1090, this);
        ar.CG().a(new s(this.lLR, this.lRh, this.lLS, this.lyE), 0);
        return false;
    }
}
