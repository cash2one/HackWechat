package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.bh;

class AppBrandProcessProxyUI$3 implements OnKeyListener {
    final /* synthetic */ String jbe;
    final /* synthetic */ AppBrandProcessProxyUI jbf;

    AppBrandProcessProxyUI$3(AppBrandProcessProxyUI appBrandProcessProxyUI, String str) {
        this.jbf = appBrandProcessProxyUI;
        this.jbe = str;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (!bh.ov(this.jbe)) {
                AppBrandProcessProxyUI.b(this.jbf).onClick(AppBrandProcessProxyUI.a(this.jbf), -3);
                dialogInterface.dismiss();
            }
            this.jbf.a(null);
        }
        return false;
    }
}
