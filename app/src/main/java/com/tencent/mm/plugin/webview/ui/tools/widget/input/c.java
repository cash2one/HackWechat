package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a;

public final class c {
    Context kaK;
    boolean kbb = false;
    int kbf;
    int kbg;
    b tLl;
    a tLm;

    public final a bUW() {
        if (this.tLl == null) {
            this.tLl = new b();
            this.tLl.kaK = this.kaK;
            this.tLl.a(this);
        }
        return this.tLl;
    }
}
