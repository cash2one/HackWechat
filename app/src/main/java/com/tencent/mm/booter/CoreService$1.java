package com.tencent.mm.booter;

import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.sdk.platformtools.aa.b;

class CoreService$1 implements b {
    final /* synthetic */ CoreService gxZ;

    CoreService$1(CoreService coreService) {
        this.gxZ = coreService;
    }

    public final void prepare() {
        AlarmReceiver.aB(this.gxZ.getApplicationContext());
    }

    public final void cancel() {
        AlarmReceiver.aC(this.gxZ.getApplicationContext());
    }
}
