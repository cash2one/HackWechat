package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.plugin.appbrand.report.a.m;
import com.tencent.mm.plugin.appbrand.report.a.m.a;

class AppBrandGuideUI$4 implements OnKeyListener {
    final /* synthetic */ AppBrandGuideUI jKG;

    AppBrandGuideUI$4(AppBrandGuideUI appBrandGuideUI) {
        this.jKG = appBrandGuideUI;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (4 != i) {
            return false;
        }
        if (1 != keyEvent.getAction()) {
            return true;
        }
        m.a(a.jIR, "");
        this.jKG.finish();
        return true;
    }
}
