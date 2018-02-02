package com.tencent.mm.plugin.webwx.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebWeiXinIntroductionUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WebWeiXinIntroductionUI tOU;

    WebWeiXinIntroductionUI$2(WebWeiXinIntroductionUI webWeiXinIntroductionUI) {
        this.tOU = webWeiXinIntroductionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tOU.finish();
        return true;
    }
}
