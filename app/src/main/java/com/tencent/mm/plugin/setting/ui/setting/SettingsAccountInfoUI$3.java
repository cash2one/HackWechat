package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SettingsAccountInfoUI$3 implements OnClickListener {
    final /* synthetic */ SettingsAccountInfoUI qiG;

    SettingsAccountInfoUI$3(SettingsAccountInfoUI settingsAccountInfoUI) {
        this.qiG = settingsAccountInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String obj = SettingsAccountInfoUI.a(this.qiG).getText().toString();
        SettingsAccountInfoUI.a(this.qiG).setText("");
        SettingsAccountInfoUI.a(this.qiG).clearFocus();
        this.qiG.df(SettingsAccountInfoUI.a(this.qiG));
        if (obj == null || obj.equals("")) {
            h.a(this.qiG, R.l.eSM, R.l.dGO, new 1(this));
            return;
        }
        k alVar = new al(obj, "", "", "");
        ar.CG().a(alVar, 0);
        SettingsAccountInfoUI settingsAccountInfoUI = this.qiG;
        Context context = this.qiG;
        this.qiG.getString(R.l.dGO);
        SettingsAccountInfoUI.a(settingsAccountInfoUI, h.a(context, this.qiG.getString(R.l.eLF), true, new 2(this, alVar)));
    }
}
