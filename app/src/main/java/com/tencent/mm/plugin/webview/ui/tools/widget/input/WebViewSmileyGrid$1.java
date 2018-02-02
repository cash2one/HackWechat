package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bx.e;

class WebViewSmileyGrid$1 implements OnItemClickListener {
    final /* synthetic */ WebViewSmileyGrid tLh;

    WebViewSmileyGrid$1(WebViewSmileyGrid webViewSmileyGrid) {
        this.tLh = webViewSmileyGrid;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == WebViewSmileyGrid.a(this.tLh).getCount() - 1) {
            if (WebViewSmileyGrid.b(this.tLh).tLm != null) {
                WebViewSmileyGrid.b(this.tLh).tLm.amZ();
            }
        } else if ((WebViewSmileyGrid.c(this.tLh) * (WebViewSmileyGrid.d(this.tLh) - 1)) + i < WebViewSmileyGrid.e(this.tLh)) {
            int c = (WebViewSmileyGrid.c(this.tLh) * (WebViewSmileyGrid.d(this.tLh) - 1)) + i;
            if (WebViewSmileyGrid.b(this.tLh).tLm != null) {
                WebViewSmileyGrid.b(this.tLh).tLm.append(e.chc().mh(c));
            }
        }
    }
}
