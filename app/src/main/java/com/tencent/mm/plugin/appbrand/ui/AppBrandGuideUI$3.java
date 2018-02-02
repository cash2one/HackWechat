package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.report.a.m;
import com.tencent.mm.plugin.appbrand.report.a.m$a;

class AppBrandGuideUI$3 implements OnClickListener {
    final /* synthetic */ AppBrandGuideUI jKG;

    AppBrandGuideUI$3(AppBrandGuideUI appBrandGuideUI) {
        this.jKG = appBrandGuideUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jKG.startActivity(new Intent(this.jKG, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
        m.a(m$a.TO_APP_LAUNCHER, "");
        this.jKG.finish();
    }
}
