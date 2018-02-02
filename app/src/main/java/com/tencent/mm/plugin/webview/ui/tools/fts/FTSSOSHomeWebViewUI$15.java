package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FTSSOSHomeWebViewUI$15 implements OnClickListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$15(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.FTS.FTSSOSHomeWebViewUI", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.tDo, "android.permission.RECORD_AUDIO", 80, "", "")), bh.cgy(), this.tDo});
        if (a.a(this.tDo, "android.permission.RECORD_AUDIO", 80, "", "")) {
            Intent intent = new Intent();
            intent.putExtra("sessionId", this.tDo.fqu);
            intent.putExtra("subSessionId", this.tDo.tjs);
            intent.setClass(this.tDo, WebSearchVoiceUI.class);
            this.tDo.startActivityForResult(intent, 1);
            this.tDo.overridePendingTransition(0, 0);
        }
    }
}
