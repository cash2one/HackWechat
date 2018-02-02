package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.model.y$b;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class WebViewUI$59 implements y$b {
    final /* synthetic */ WebViewUI tAv;
    private Map<Integer, Integer> tBr = new HashMap();

    WebViewUI$59(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void Ai(int i) {
        WebViewUI.e(this.tAv, i);
        if (this.tBr.containsKey(Integer.valueOf(i))) {
            this.tBr.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.tBr.get(Integer.valueOf(i))).intValue() + 1));
            return;
        }
        this.tBr.put(Integer.valueOf(i), Integer.valueOf(1));
    }

    public final void remove(int i) {
        WebViewUI.f(this.tAv, i);
        if (this.tBr.containsKey(Integer.valueOf(i))) {
            this.tBr.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.tBr.get(Integer.valueOf(i))).intValue() - 1));
            return;
        }
        this.tBr.put(Integer.valueOf(i), Integer.valueOf(0));
    }

    public final boolean bQL() {
        for (Entry value : this.tBr.entrySet()) {
            if (((Integer) value.getValue()).intValue() > 0) {
                return true;
            }
        }
        return false;
    }
}
