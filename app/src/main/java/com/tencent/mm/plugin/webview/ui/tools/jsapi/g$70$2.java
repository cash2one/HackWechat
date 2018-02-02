package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.70;
import com.tencent.mm.sdk.platformtools.x;

class g$70$2 implements b {
    final /* synthetic */ 70 tJb;

    g$70$2(70 70) {
        this.tJb = 70;
    }

    public final void onError() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("playResult", "onVoicePlayEnd:fail");
            bundle.putString("localId", this.tJb.jjz);
            g.z(this.tJb.tIj).n(2002, bundle);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
        }
    }
}
