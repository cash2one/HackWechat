package com.tencent.mm.ui;

import com.tencent.mm.g.a.hz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class j$1 extends c<hz> {
    final /* synthetic */ j xFL;

    j$1(j jVar) {
        this.xFL = jVar;
        this.xen = hz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hz hzVar = (hz) bVar;
        if (hzVar == null || hzVar.fyu == null || hzVar.fyu.fyv == null) {
            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event is illegal event[%s]", new Object[]{hzVar});
        } else {
            x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event launcherUI isResumeStatus[%b], tid[%d]", new Object[]{Boolean.valueOf(this.xFL.xFF.cmA()), Long.valueOf(Thread.currentThread().getId())});
            if (this.xFL.xFF.cmA()) {
                this.xFL.xFG = null;
                this.xFL.a(hzVar.fyu);
            } else {
                this.xFL.xFG = hzVar.fyu;
            }
        }
        return false;
    }
}
