package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.c.a;

public class WebViewStubService$b extends a {
    public int errCode;
    public int errType;
    public String fnL;
    public Bundle msB;
    public int type;

    public final int getType() {
        return this.type;
    }

    public final int bRK() {
        return this.errType;
    }

    public final int bRL() {
        return this.errCode;
    }

    public final String KM() {
        return this.fnL;
    }

    public final Bundle getData() {
        return this.msB;
    }
}
