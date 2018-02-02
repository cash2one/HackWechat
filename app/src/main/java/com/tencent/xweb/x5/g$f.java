package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.xweb.f;

public class g$f extends f {
    public JsResult ArQ;

    public g$f(JsResult jsResult) {
        this.ArQ = jsResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        this.ArQ.confirm();
    }

    public final void cancel() {
        this.ArQ.cancel();
    }
}
