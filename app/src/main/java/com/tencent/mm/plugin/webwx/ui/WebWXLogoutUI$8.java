package com.tencent.mm.plugin.webwx.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class WebWXLogoutUI$8 implements OnClickListener {
    final /* synthetic */ WebWXLogoutUI tOP;

    WebWXLogoutUI$8(WebWXLogoutUI webWXLogoutUI) {
        this.tOP = webWXLogoutUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k amVar = new am(1);
        ar.CG().a(amVar, 0);
        WebWXLogoutUI webWXLogoutUI = this.tOP;
        Context context = this.tOP.mController.xIM;
        this.tOP.getString(R.l.dGO);
        WebWXLogoutUI.a(webWXLogoutUI, h.a(context, null, true, new 1(this, amVar)));
    }
}
