package com.tencent.mm.plugin.game.gamewebview.e;

import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$a implements b {
    final /* synthetic */ c naM;

    private c$a(c cVar) {
        this.naM = cVar;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://jump/");
    }

    public final boolean BU(String str) {
        if (this.naM.juR == null || !this.naM.juR.bSt().cdA()) {
            x.e("MicroMsg.UrlHandler", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[]{str});
        } else {
            GWMainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 1;
            Bundle bundle = new Bundle();
            bundle.putBoolean("permission_allow", this.naM.juR.bSs().gn(7));
            bundle.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
            commonLogicTask.msB = bundle;
            GameWebViewMainProcessService.a(commonLogicTask);
        }
        return true;
    }
}
