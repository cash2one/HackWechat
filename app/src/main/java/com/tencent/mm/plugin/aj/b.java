package com.tencent.mm.plugin.aj;

import android.webkit.JavascriptInterface;

public final class b implements com.tencent.mm.bh.b {
    public com.tencent.mm.bh.b tjq;

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        if (this.tjq != null) {
            this.tjq._sendMessage(str);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(String str) {
        if (this.tjq != null) {
            this.tjq._getAllHosts(str);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(String str) {
        if (this.tjq != null) {
            this.tjq._getHtmlContent(str);
        }
    }
}
