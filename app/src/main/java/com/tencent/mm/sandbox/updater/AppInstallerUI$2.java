package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class AppInstallerUI$2 implements OnClickListener {
    final /* synthetic */ AppInstallerUI xcj;

    AppInstallerUI$2(AppInstallerUI appInstallerUI) {
        this.xcj = appInstallerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
        if (AppInstallerUI.b(this.xcj) == 2) {
            i.af(this.xcj, 3);
        }
        String IB = c.IB(AppInstallerUI.c(this.xcj));
        x.d("MicroMsg.AppInstallerUI", IB);
        if (IB != null) {
            a.xdL.ac(1, true);
            g.pQN.a(405, 72, 1, true);
            AppInstallerUI.a(this.xcj, IB);
            return;
        }
        g.pQN.a(405, 73, 1, true);
        x.e("MicroMsg.AppInstallerUI", "pack not found!");
        h.bu(this.xcj, this.xcj.getString(R.l.eRS));
        i.ceB();
        this.xcj.finish();
    }
}
