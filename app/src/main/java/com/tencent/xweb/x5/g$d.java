package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.xweb.j.a;

public class g$d extends a {
    public WebChromeClient.a ArO;

    public g$d(WebChromeClient.a aVar) {
        this.ArO = aVar;
    }

    public final int getMode() {
        if (this.ArO != null) {
            return this.ArO.getMode();
        }
        return 0;
    }

    public final String[] getAcceptTypes() {
        if (this.ArO != null) {
            return this.ArO.getAcceptTypes();
        }
        return new String[0];
    }

    public final boolean isCaptureEnabled() {
        if (this.ArO != null) {
            return this.ArO.isCaptureEnabled();
        }
        return false;
    }
}
