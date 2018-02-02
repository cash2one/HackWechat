package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class AppInstallerUI$5 implements OnClickListener {
    final /* synthetic */ AppInstallerUI xcj;

    AppInstallerUI$5(AppInstallerUI appInstallerUI) {
        this.xcj = appInstallerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.a(405, 75, 1, true);
        if (AppInstallerUI.e(this.xcj) != null && !AppInstallerUI.e(this.xcj).isShowing()) {
            AppInstallerUI.e(this.xcj).show();
        }
    }
}
