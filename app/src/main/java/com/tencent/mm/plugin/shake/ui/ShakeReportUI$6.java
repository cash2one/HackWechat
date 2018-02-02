package com.tencent.mm.plugin.shake.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ShakeReportUI$6 implements IdleHandler {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$6(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final boolean queueIdle() {
        u.a(this.qsi, 0, this.qsi.getString(R.l.eOU));
        ar.Hg();
        c.CU().set(4117, Boolean.valueOf(true));
        return false;
    }
}
