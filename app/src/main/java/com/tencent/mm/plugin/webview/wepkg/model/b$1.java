package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

class b$1 implements Runnable {
    final /* synthetic */ b tMA;

    b$1(b bVar) {
        this.tMA = bVar;
    }

    public final void run() {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        List<WepkgVersion> list = wepkgCrossProcessTask.tMT;
        if (bh.cA(list)) {
            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "no need to clean wepkg");
            return;
        }
        x.i("MicroMsg.Wepkg.CleanWepkgMgr", "need to clean list.size:%s", new Object[]{Integer.valueOf(list.size())});
        for (WepkgVersion wepkgVersion : list) {
            if (wepkgVersion != null) {
                b.a(this.tMA, wepkgVersion.tNm);
            }
        }
    }
}
