package com.tencent.mm.plugin.location.model;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.PayuSecureEncrypt;

class o$2 implements a {
    final /* synthetic */ o nRZ;

    o$2(o oVar) {
        this.nRZ = oVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        x.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d)});
        if (this.nRZ.nRV) {
            this.nRZ.nRV = false;
            this.nRZ.nRX = System.currentTimeMillis();
            long j = this.nRZ.nRX - this.nRZ.nRW;
            x.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[]{Long.valueOf(j)});
            g.pQN.h(10997, new Object[]{PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "", Integer.valueOf(0), Long.valueOf(j)});
        }
        if (!(this.nRZ.nRM == null || this.nRZ.nRM.wTo == null)) {
            this.nRZ.nRM.wTo.vNP = (double) f2;
            this.nRZ.nRM.wTo.vNO = (double) f;
        }
        return true;
    }
}
