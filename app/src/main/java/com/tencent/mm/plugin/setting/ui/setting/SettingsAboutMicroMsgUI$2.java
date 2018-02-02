package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.modelstat.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class SettingsAboutMicroMsgUI$2 implements OnClickListener {
    private ak hHu = null;
    private e hPs = null;
    final /* synthetic */ SettingsAboutMicroMsgUI qie;

    SettingsAboutMicroMsgUI$2(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        this.qie = settingsAboutMicroMsgUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.SO().SP();
        ar.Hg();
        if (com.tencent.mm.z.c.ET()) {
            n CG = ar.CG();
            e 1 = new 1(this);
            this.hPs = 1;
            CG.a(281, 1);
            k amVar = new am(2);
            ar.CG().a(amVar, 0);
            this.hHu = new ak(new 2(this, amVar), false);
            this.hHu.J(5000, 5000);
            SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = this.qie;
            Context context = this.qie.mController.xIM;
            this.qie.getString(R.l.dGO);
            SettingsAboutMicroMsgUI.a(settingsAboutMicroMsgUI, h.a(context, this.qie.getString(R.l.eXm), true, new 3(this, amVar)));
            return;
        }
        SettingsAboutMicroMsgUI.b(this.qie);
    }
}
