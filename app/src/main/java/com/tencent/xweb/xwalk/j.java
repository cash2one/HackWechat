package com.tencent.xweb.xwalk;

import android.view.View;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class j extends XWalkUIClient {
    public j(XWalkView xWalkView) {
        super(xWalkView);
    }

    public final void a(XWalkView xWalkView, String str) {
        super.onPageLoadStarted(xWalkView, str);
    }

    public final void cIT() {
        super.onHideCustomView();
    }

    public final void a(View view, CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    public final boolean a(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        return super.onJsPrompt(xWalkView, str, str2, str3, xWalkJavascriptResult);
    }

    public final boolean a(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        return super.onJsConfirm(xWalkView, str, str2, xWalkJavascriptResult);
    }

    public final boolean b(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        return super.onJsAlert(xWalkView, str, str2, xWalkJavascriptResult);
    }
}
