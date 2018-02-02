package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.h.10;
import com.tencent.mm.plugin.webview.wepkg.model.h.11;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ac;

class g$6 extends a {
    final /* synthetic */ String tMB;
    final /* synthetic */ a tNk;

    g$6(String str, a aVar) {
        this.tMB = str;
        this.tNk = aVar;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        String str = this.tMB;
        a aVar = this.tNk;
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 3006;
        wepkgCrossProcessTask.tMS.tNm = str;
        wepkgCrossProcessTask.tMS.tNJ = false;
        if (ac.cfw()) {
            d.Dm().F(new 10(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.jcI = new 11(aVar, wepkgCrossProcessTask);
        wepkgCrossProcessTask.afi();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }
}
