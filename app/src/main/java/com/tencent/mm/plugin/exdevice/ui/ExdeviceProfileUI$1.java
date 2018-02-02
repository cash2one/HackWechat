package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceProfileUI$1 implements b<i> {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$1(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        i iVar = (i) kVar;
        if (this.lVZ.isFinishing() || ExdeviceProfileUI.a(this.lVZ)) {
            ExdeviceProfileUI.b(this.lVZ);
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
            return;
        }
        ExdeviceProfileUI.c(this.lVZ);
        if (i == 0 && i2 == 0 && iVar != null) {
            this.lVZ.runOnUiThread(new 1(this, iVar));
            ExdeviceProfileUI.a(this.lVZ, iVar.lPb);
            ExdeviceProfileUI.a(this.lVZ, iVar.lOX);
            ExdeviceProfileUI.b(this.lVZ, iVar.lOY);
            ExdeviceProfileUI.a(this.lVZ, ExdeviceProfileUI.aF(iVar.lOZ));
            ExdeviceProfileUI.a(this.lVZ, iVar.lPf);
            ExdeviceProfileUI.b(this.lVZ, iVar.lPe);
            ExdeviceProfileUI.c(this.lVZ, iVar.lPd);
            ExdeviceProfileUI.a(this.lVZ, iVar.lPg);
            ExdeviceProfileUI.b(this.lVZ, iVar.lPh);
            ExdeviceProfileUI.c(this.lVZ, iVar.lOU);
            this.lVZ.runOnUiThread(new 2(this));
            if (!ExdeviceProfileUI.h(this.lVZ)) {
                ExdeviceProfileUI exdeviceProfileUI = this.lVZ;
                ExdeviceProfileUI.i(this.lVZ);
                ExdeviceProfileUI.j(exdeviceProfileUI);
            }
            this.lVZ.runOnUiThread(new 3(this));
            ExdeviceProfileUI.m(this.lVZ);
            ExdeviceProfileUI.b(this.lVZ);
        }
    }
}
