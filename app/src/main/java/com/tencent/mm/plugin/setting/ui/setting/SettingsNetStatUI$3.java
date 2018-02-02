package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bh;

class SettingsNetStatUI$3 implements OnClickListener {
    final /* synthetic */ SettingsNetStatUI qkl;

    SettingsNetStatUI$3(SettingsNetStatUI settingsNetStatUI) {
        this.qkl = settingsNetStatUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        m Tg = q.Tg();
        int cgs = (int) (bh.cgs() / 86400000);
        au auVar = Tg.hSq;
        synchronized (auVar) {
            auVar.nId.trimToSize(-1);
            auVar.xhw.clear();
            auVar.fhK.TG();
            auVar.xhy.TG();
            auVar.fhN = true;
        }
        Tg.hhp.delete("netstat", null, null);
        k kVar = new k();
        kVar.hRC = cgs;
        kVar.id = -1;
        Tg.b(kVar);
        SettingsNetStatUI.b(this.qkl);
    }
}
