package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class MMSightEditUI$1 implements Runnable {
    final /* synthetic */ long mUn;
    final /* synthetic */ MMSightEditUI oxG;

    MMSightEditUI$1(MMSightEditUI mMSightEditUI, long j) {
        this.oxG = mMSightEditUI;
        this.mUn = j;
    }

    public final void run() {
        x.i("MicroMsg.MMSightEditUI", "connect cost %sms", new Object[]{Long.valueOf(bh.bA(this.mUn))});
        if (CaptureMMProxy.getInstance() != null) {
            q.eI(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        MMSightEditUI.a(this.oxG);
    }
}
