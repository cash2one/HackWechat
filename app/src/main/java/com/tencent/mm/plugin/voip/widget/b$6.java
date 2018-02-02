package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$6 implements a {
    final /* synthetic */ String hMZ;
    final /* synthetic */ String icx;
    private int mCount = 0;
    final /* synthetic */ b svK;
    final /* synthetic */ String svM;

    b$6(b bVar, String str, String str2, String str3) {
        this.svK = bVar;
        this.svM = str;
        this.icx = str2;
        this.hMZ = str3;
    }

    public final boolean uF() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.e(this.svK));
        this.mCount++;
        if (b.e(this.svK) == 8 || b.e(this.svK) == 262 || !d.bIq()) {
            x.i("MicroMsg.Voip.VoipSmallWindow", "CALLING_STATE_FINISH state..cancel notification..");
            ar.getNotification().cancel(40);
            if (!(b.g(this.svK) == null || b.g(this.svK).cfK())) {
                b.g(this.svK).TG();
            }
            return false;
        }
        this.svK.e(this.svM + (this.mCount % 2 == 1 ? " " : ""), this.icx, this.hMZ, false);
        return true;
    }
}
