package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.JsPromptResult;

class SystemWebChromeClient$JsPromptResultImpl implements JsPromptResult {
    android.webkit.JsPromptResult mJsPromptResult;
    final /* synthetic */ SystemWebChromeClient this$0;

    SystemWebChromeClient$JsPromptResultImpl(SystemWebChromeClient systemWebChromeClient, android.webkit.JsPromptResult jsPromptResult) {
        this.this$0 = systemWebChromeClient;
        this.mJsPromptResult = jsPromptResult;
    }

    public void cancel() {
        this.mJsPromptResult.cancel();
    }

    public void confirm() {
        this.mJsPromptResult.confirm();
    }

    public void confirm(String str) {
        this.mJsPromptResult.confirm(str);
    }
}
