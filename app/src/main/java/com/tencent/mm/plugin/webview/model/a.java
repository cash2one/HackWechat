package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.ag;

public final class a {
    public volatile ag trM = new ag("WebviewWorkerThread");
    aj trN;

    public a(aj ajVar) {
        this.trN = ajVar;
    }

    public final ag Dm() {
        if (this.trM == null) {
            this.trM = new ag("WebviewWorkerThread");
        }
        return this.trM;
    }
}
