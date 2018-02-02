package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends c {
    public void enter() {
        super.enter();
        x.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
    }

    public void exit() {
        super.exit();
        x.i("MicroMsg.LoggerState", getName() + " [EXITING]");
    }
}
