package com.tencent.mm.plugin.shake.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.ui.ShakeReportUI.4;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ShakeReportUI$4$1 implements IdleHandler {
    final /* synthetic */ 4 qsj;

    ShakeReportUI$4$1(4 4) {
        this.qsj = 4;
    }

    public final boolean queueIdle() {
        u.a(this.qsj.qsi, 0, this.qsj.qsi.getString(R.l.eOU));
        ar.Hg();
        c.CU().set(4117, Boolean.valueOf(true));
        return false;
    }
}
