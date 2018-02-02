package com.tencent.xweb.x5;

import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.xweb.e;

public class g$g extends e {
    public JsPromptResult ArR;

    public g$g(JsPromptResult jsPromptResult) {
        this.ArR = jsPromptResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        this.ArR.confirm();
    }

    public final void cancel() {
        this.ArR.cancel();
    }
}
