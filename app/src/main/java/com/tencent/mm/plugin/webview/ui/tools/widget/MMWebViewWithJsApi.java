package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.p;

public class MMWebViewWithJsApi extends MMWebView {
    private e tKv;
    public boolean tKw;

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tKw = true;
        cyU();
        getSettings().setJavaScriptEnabled(true);
        getSettings().cIy();
        setWebChromeClient(new d(this));
        setWebViewClient(new e(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!s.SQ(userAgentString)) {
            getSettings().setUserAgentString(s.aL(getContext(), userAgentString));
        }
    }

    public void setWebViewClient(p pVar) {
        super.setWebViewClient(pVar);
        if (pVar instanceof e) {
            this.tKv = (e) pVar;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tKv != null && this.tKw) {
            this.tKv.cleanup();
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (this.tKv != null) {
            this.tKv.tKj = true;
        }
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.tKv != null) {
            this.tKv.tKj = true;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }
}
