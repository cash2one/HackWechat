package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.x;

class AppInstallerUI$4 implements OnClickListener {
    final /* synthetic */ AppInstallerUI xcj;

    AppInstallerUI$4(AppInstallerUI appInstallerUI) {
        this.xcj = appInstallerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
        if (AppInstallerUI.e(this.xcj) != null && AppInstallerUI.e(this.xcj).isShowing()) {
            AppInstallerUI.e(this.xcj).dismiss();
        }
        a.xdL.ac(2, true);
        if (AppInstallerUI.b(this.xcj) == 2) {
            i.af(this.xcj, 4);
        }
        g.pQN.a(405, 74, 1, true);
        i.cew();
        AppInstallerUI.d(this.xcj);
    }
}
