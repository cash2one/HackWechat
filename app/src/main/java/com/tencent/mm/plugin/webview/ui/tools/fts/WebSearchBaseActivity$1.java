package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebSearchBaseActivity$1 implements OnMenuItemClickListener {
    final /* synthetic */ WebSearchBaseActivity tEM;

    WebSearchBaseActivity$1(WebSearchBaseActivity webSearchBaseActivity) {
        this.tEM = webSearchBaseActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tEM.finish();
        return true;
    }
}
