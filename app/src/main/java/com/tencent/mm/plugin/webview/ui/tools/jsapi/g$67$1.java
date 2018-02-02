package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.67;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

class g$67$1 implements Runnable {
    final /* synthetic */ fc tIZ;
    final /* synthetic */ 67 tJa;

    g$67$1(67 67, fc fcVar) {
        this.tJa = 67;
        this.tIZ = fcVar;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", new Object[]{this.tJa.tIY.fus});
        try {
            this.tJa.tIj.tHW = null;
            Bundle bundle = new Bundle();
            bundle.putString("localId", this.tJa.tIY.fus);
            String str = "recordResult";
            StringBuilder stringBuilder = new StringBuilder("onVoiceRecordEnd:");
            String str2 = (this.tIZ.fub.fuc != 2 || this.tIZ.fub.fuc == 3) ? "ok" : "fail";
            bundle.putString(str, stringBuilder.append(str2).toString());
            if (this.tJa.tIj.fBH != null) {
                this.tJa.tIj.fBH.n(TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER, bundle);
            } else {
                x.e("MicroMsg.MsgHandler", "callbacker is null");
            }
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "callback stop record failed");
        }
    }
}
