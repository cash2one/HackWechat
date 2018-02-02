package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class t$5 extends bc<Object> {
    final /* synthetic */ int fhx;
    final /* synthetic */ String gIT;
    final /* synthetic */ t hZT;
    final /* synthetic */ int hZY;
    final /* synthetic */ boolean hZZ;

    t$5(t tVar, int i, int i2, String str, boolean z) {
        this.hZT = tVar;
        this.fhx = i;
        this.hZY = i2;
        this.gIT = str;
        this.hZZ = z;
        super(1000, null);
    }

    protected final Object run() {
        if (this.fhx == 3) {
            Date date = new Date();
            date.setTime(bh.Wp() - (86400000 * ((long) this.hZY)));
            MMLogic.uploadFile(e.gZM + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", this.gIT, "");
        } else if (this.fhx == 2) {
            x.cfk();
            MMLogic.uploadLog(new int[]{this.hZY}, this.hZZ, this.gIT, "");
        } else {
            x.cfk();
        }
        return null;
    }
}
