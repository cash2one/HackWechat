package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.p;

public class WebViewTestUI extends MMActivity {
    private p iTV = new 1(this);
    MMWebViewWithJsApi tyl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        this.tyl = a.dS(this);
        this.tyl.setWebViewClient(this.iTV);
        setContentView(this.tyl);
        this.tyl.loadUrl(stringExtra);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
