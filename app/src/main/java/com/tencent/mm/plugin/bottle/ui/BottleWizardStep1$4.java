package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class BottleWizardStep1$4 implements c {
    final /* synthetic */ BottleWizardStep1 kCq;

    BottleWizardStep1$4(BottleWizardStep1 bottleWizardStep1) {
        this.kCq = bottleWizardStep1;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                x.i("MicroMsg.BottleWizardStep1", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.kCq.mController.xIM, "android.permission.CAMERA", 16, "", "")), bh.cgy(), this.kCq.mController.xIM});
                if (a.a(this.kCq.mController.xIM, "android.permission.CAMERA", 16, "", "")) {
                    BottleWizardStep1.b(this.kCq);
                    return;
                }
                return;
            case 1:
                k.a(this.kCq, 2, null);
                return;
            default:
                return;
        }
    }
}
