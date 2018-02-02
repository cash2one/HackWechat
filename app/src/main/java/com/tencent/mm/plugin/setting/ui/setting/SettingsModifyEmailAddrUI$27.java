package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SettingsModifyEmailAddrUI$27 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyEmailAddrUI qjX;

    SettingsModifyEmailAddrUI$27(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        this.qjX = settingsModifyEmailAddrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SettingsModifyEmailAddrUI.a(this.qjX, SettingsModifyEmailAddrUI.c(this.qjX).getText().toString().trim());
        if (bh.Vt(SettingsModifyEmailAddrUI.d(this.qjX))) {
            ar.Hg();
            Integer num = (Integer) c.CU().get(7, null);
            boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
            Boolean valueOf = Boolean.valueOf(z);
            if (SettingsModifyEmailAddrUI.d(this.qjX).equals(SettingsModifyEmailAddrUI.e(this.qjX)) && valueOf.booleanValue()) {
                this.qjX.finish();
            } else {
                final k aVar = new a(a.hjv, SettingsModifyEmailAddrUI.d(this.qjX));
                ar.CG().a(aVar, 0);
                SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.qjX;
                Context context = this.qjX;
                this.qjX.getString(R.l.dGO);
                SettingsModifyEmailAddrUI.a(settingsModifyEmailAddrUI, h.a(context, this.qjX.getString(R.l.eKZ), true, new OnCancelListener(this) {
                    final /* synthetic */ SettingsModifyEmailAddrUI$27 qkc;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ar.CG().c(aVar);
                    }
                }));
                this.qjX.aWs();
            }
        } else {
            h.h(this.qjX.mController.xIM, R.l.eSJ, R.l.dGO);
        }
        return true;
    }
}
