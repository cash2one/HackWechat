package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.8;
import com.tencent.mm.z.ar;

class WebWXLogoutUI$8$1 implements OnCancelListener {
    final /* synthetic */ am qig;
    final /* synthetic */ 8 tOR;

    WebWXLogoutUI$8$1(8 8, am amVar) {
        this.tOR = 8;
        this.qig = amVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qig);
        if (WebWXLogoutUI.i(this.tOR.tOP) != null) {
            WebWXLogoutUI.i(this.tOR.tOP).cancel();
        }
    }
}
