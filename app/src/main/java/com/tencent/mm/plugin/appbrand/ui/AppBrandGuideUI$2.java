package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.report.a.m;
import com.tencent.mm.plugin.appbrand.report.a.m.a;

class AppBrandGuideUI$2 implements OnClickListener {
    final /* synthetic */ AppBrandGuideUI jKG;

    AppBrandGuideUI$2(AppBrandGuideUI appBrandGuideUI) {
        this.jKG = appBrandGuideUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        m.a(a.jIP, "");
        this.jKG.finish();
    }
}
