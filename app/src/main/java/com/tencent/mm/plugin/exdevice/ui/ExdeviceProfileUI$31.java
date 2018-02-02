package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceProfileUI$31 implements b<h> {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$31(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.lVZ.finish();
        }
    }
}
