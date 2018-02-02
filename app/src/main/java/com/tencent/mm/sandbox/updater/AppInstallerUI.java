package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;

public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI xch = null;
    private String desc;
    private String fqR;
    private i pyk = null;
    private int ruR;
    private i xcg = null;
    private OnClickListener xci = new 2(this);

    static /* synthetic */ void a(AppInstallerUI appInstallerUI) {
        x.d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.pyk != null && appInstallerUI.pyk.isShowing()) {
            appInstallerUI.pyk.dismiss();
        }
        if (appInstallerUI.xcg == null || !appInstallerUI.xcg.isShowing()) {
            appInstallerUI.xcg = h.a(appInstallerUI, R.l.dNo, R.l.dGO, R.l.dNp, R.l.dXC, false, new 4(appInstallerUI), new 5(appInstallerUI));
            return;
        }
        x.d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
    }

    public static AppInstallerUI cei() {
        return xch;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.AppInstallerUI", "onCreate");
        c.h(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppUpdaterUI.cej() != null && !AppUpdaterUI.cej().isFinishing()) {
            x.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
        } else if (xch == null || xch.isFinishing() || xch == this) {
            xch = this;
            this.fqR = i.bYY();
            if (bh.ov(this.fqR) || com.tencent.mm.sandbox.monitor.c.IB(this.fqR) == null) {
                finish();
                return;
            }
            this.desc = i.cet();
            this.ruR = i.ceu();
            setContentView(R.i.empty);
            a aVar = new a(this);
            aVar.Ez(R.l.ejp);
            aVar.mi(true);
            aVar.d(new 1(this));
            aVar.YG(getString(R.l.ejs, new Object[]{this.desc}));
            aVar.EC(R.l.epy).a(false, this.xci);
            aVar.ED(R.l.eRQ).b(null);
            this.pyk = aVar.akx();
            this.pyk.setCanceledOnTouchOutside(false);
            this.pyk.show();
            g.pQN.a(405, 71, 1, true);
            if (this.ruR == 2) {
                i.f(this, 2, i.cev() + 1);
            }
        } else {
            x.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
        }
    }

    protected void onDestroy() {
        x.d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.pyk != null && this.pyk.isShowing()) {
            this.pyk.dismiss();
        }
        if (this.xcg != null && this.xcg.isShowing()) {
            this.xcg.dismiss();
        }
        if (xch == this) {
            xch = null;
        }
        c.i(hashCode(), this);
        super.onDestroy();
    }
}
