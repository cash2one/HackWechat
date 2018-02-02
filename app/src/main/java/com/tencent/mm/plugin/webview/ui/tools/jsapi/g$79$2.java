package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.ff;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.79;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

class g$79$2 implements Runnable {
    final /* synthetic */ 79 tJf;
    final /* synthetic */ ff tJg;

    g$79$2(79 79, ff ffVar) {
        this.tJf = 79;
        this.tJg = ffVar;
    }

    public final void run() {
        if (this.tJg.fur.aow) {
            if (g.k(this.tJf.tIj) != null) {
                g.k(this.tJf.tIj).dismiss();
                g.a(this.tJf.tIj, null);
            }
            if (bh.ov(this.tJg.fur.content)) {
                g.a(this.tJf.tIj, this.tJf.tIg, "translateVoice:fail", null);
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("translateResult", this.tJg.fur.content);
            g.a(this.tJf.tIj, this.tJf.tIg, "translateVoice:ok", hashMap);
        }
    }
}
