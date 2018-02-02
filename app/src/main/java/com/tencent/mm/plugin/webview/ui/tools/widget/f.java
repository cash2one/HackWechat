package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.ui.widget.MMWebView;

public final class f extends e {
    b tKs = null;
    private g tKt = null;

    public f(MMWebView mMWebView, boolean z, b bVar) {
        super(mMWebView, false);
        this.tKs = bVar;
    }

    protected final g ahF() {
        if (this.tKt == null) {
            this.tKt = new 1(this);
        }
        return this.tKt;
    }
}
