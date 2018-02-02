package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webwx.a;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class WebWXPopupUnlockUI$1 implements OnClickListener {
    final /* synthetic */ Dialog nxc;
    final /* synthetic */ WebWXPopupUnlockUI tOS;

    WebWXPopupUnlockUI$1(WebWXPopupUnlockUI webWXPopupUnlockUI, Dialog dialog) {
        this.tOS = webWXPopupUnlockUI;
        this.nxc = dialog;
    }

    public final void onClick(View view) {
        ar.CG().a(new b(2), 0);
        x.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
        a.ift.ep(1);
        x.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
        this.nxc.dismiss();
    }
}
