package com.tencent.xweb.sys;

import android.webkit.JsResult;
import com.tencent.xweb.f;

public class c$d extends f {
    public JsResult mJsResult;

    public c$d(JsResult jsResult) {
        this.mJsResult = jsResult;
    }

    public final void confirmWithResult(String str) {
    }

    public final void confirm() {
        if (this.mJsResult != null) {
            this.mJsResult.confirm();
        }
    }

    public final void cancel() {
        if (this.mJsResult != null) {
            this.mJsResult.cancel();
        }
    }
}
