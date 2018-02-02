package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import com.tencent.mm.R;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.k.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

class SettingsNotificationUI$2 implements OnClickListener {
    final /* synthetic */ SettingsNotificationUI qkm;

    SettingsNotificationUI$2(SettingsNotificationUI settingsNotificationUI) {
        this.qkm = settingsNotificationUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.bk(false);
        au auVar = new au();
        auVar.eR(2);
        auVar.aq(System.currentTimeMillis());
        auVar.setType(1);
        auVar.dS("weixin");
        auVar.setContent(this.qkm.mController.xIM.getString(R.l.eMd, new Object[]{Build.MODEL}));
        ba.i(auVar);
        ar.Hg();
        aj WY = c.Fd().WY("weixin");
        if (WY != null) {
            WY.setContent(this.qkm.mController.xIM.getString(R.l.eMd, new Object[]{Build.MODEL}));
            WY.eO(WY.field_unReadCount + 1);
            ar.Hg();
            c.Fd().a(WY, "weixin");
        } else {
            ae aeVar = new ae();
            aeVar.setContent(this.qkm.mController.xIM.getString(R.l.eMd, new Object[]{Build.MODEL}));
            aeVar.setUsername("weixin");
            aeVar.eO(1);
            ar.Hg();
            c.Fd().d(aeVar);
        }
        g.pQN.a(500, 3, 1, false);
    }
}
