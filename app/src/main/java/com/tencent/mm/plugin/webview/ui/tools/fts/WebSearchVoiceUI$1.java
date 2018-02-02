package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.websearch.a.a;

class WebSearchVoiceUI$1 implements a {
    final /* synthetic */ WebSearchVoiceUI tEP;

    WebSearchVoiceUI$1(WebSearchVoiceUI webSearchVoiceUI) {
        this.tEP = webSearchVoiceUI;
    }

    public final void bTZ() {
        this.tEP.setResult(0);
        g.pQN.h(15178, Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(this.tEP), WebSearchVoiceUI.b(this.tEP));
        this.tEP.finish();
    }

    public final void Px(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 2) {
            str = str.substring(0, str.length() - 1);
        }
        Intent intent = new Intent();
        intent.putExtra("text", str);
        this.tEP.setResult(0, intent);
        g.pQN.h(15178, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.a(this.tEP), WebSearchVoiceUI.b(this.tEP));
        this.tEP.finish();
    }

    public final void ky(boolean z) {
        if (z) {
            g.pQN.h(15178, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(this.tEP), WebSearchVoiceUI.b(this.tEP));
        }
    }
}
