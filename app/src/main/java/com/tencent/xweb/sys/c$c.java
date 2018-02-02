package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.xweb.e;

public class c$c extends e {
    public JsPromptResult Are;

    public c$c(JsPromptResult jsPromptResult) {
        this.Are = jsPromptResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        if (this.Are != null) {
            this.Are.confirm();
        }
    }

    public final void cancel() {
        if (this.Are != null) {
            this.Are.cancel();
        }
    }
}
