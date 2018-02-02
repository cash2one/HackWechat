package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.welab.b;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.x;

class WelabAppInfoUI$3 implements OnClickListener {
    final /* synthetic */ WelabAppInfoUI tPR;

    WelabAppInfoUI$3(WelabAppInfoUI welabAppInfoUI) {
        this.tPR = welabAppInfoUI;
    }

    public final void onClick(View view) {
        x.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.b(this.tPR));
        b bVu = b.bVu();
        Activity activity = this.tPR;
        String b = WelabAppInfoUI.b(this.tPR);
        com.tencent.mm.plugin.welab.a.a.b bVar = (com.tencent.mm.plugin.welab.a.a.b) bVu.tPy.get(b);
        if (bVar != null) {
            x.i("WelabMgr", "use custome opener to open " + b);
            bVar.e(activity, b);
        } else {
            x.i("WelabMgr", "use default opener open " + b);
            if (bVu.Qw(b).field_Type != 2) {
                x.e("WelabMgr", "can not find opener for " + b);
            } else if (bVu.tPz != null) {
                bVu.tPz.e(activity, b);
            } else {
                x.e("WelabMgr", "defaultWeAppOpener is null!");
            }
        }
        e.o(WelabAppInfoUI.b(this.tPR), 7, WelabAppInfoUI.c(this.tPR));
    }
}
