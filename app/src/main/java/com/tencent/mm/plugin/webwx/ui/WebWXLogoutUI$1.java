package com.tencent.mm.plugin.webwx.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WebWXLogoutUI$1 implements OnClickListener {
    final /* synthetic */ WebWXLogoutUI tOP;

    WebWXLogoutUI$1(WebWXLogoutUI webWXLogoutUI) {
        this.tOP = webWXLogoutUI;
    }

    public final void onClick(View view) {
        WebWXLogoutUI.a(this.tOP, !WebWXLogoutUI.a(this.tOP));
        WebWXLogoutUI.b(this.tOP, WebWXLogoutUI.a(this.tOP));
        WebWXLogoutUI.b(this.tOP);
    }
}
