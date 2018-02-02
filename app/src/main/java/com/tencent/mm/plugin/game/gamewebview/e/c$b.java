package com.tencent.mm.plugin.game.gamewebview.e;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$b implements b {
    final /* synthetic */ c naM;

    private c$b(c cVar) {
        this.naM = cVar;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://");
    }

    public final boolean BU(String str) {
        if (!d.ae(str, this.naM.naL)) {
            return false;
        }
        try {
            GWMainProcessTask commonLogicTask = new CommonLogicTask();
            if ("weixin://dl/posts".equals(str)) {
                commonLogicTask.type = 3;
                GameWebViewMainProcessService.a(commonLogicTask);
                return true;
            } else if ("weixin://dl/moments".equals(str)) {
                commonLogicTask.type = 4;
                GameWebViewMainProcessService.a(commonLogicTask);
                return true;
            } else if ("weixin://dl/scan".equals(str)) {
                com.tencent.mm.bm.d.a(ac.getContext(), "scanner", ".ui.SingleTopScanUI", new Intent(), false);
                return true;
            } else {
                d.Rh(str);
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UrlHandler", "kv report fail, ex = %s", new Object[]{e.getMessage()});
            return true;
        }
    }
}
