package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.database.Cursor;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class CleanChattingUI$6 implements Runnable {
    final /* synthetic */ CleanChattingUI lgN;

    CleanChattingUI$6(CleanChattingUI cleanChattingUI) {
        this.lgN = cleanChattingUI;
    }

    public final void run() {
        if (!CleanChattingUI.c(this.lgN)) {
            x.i("MicroMsg.CleanChattingUI", "load contact cursor now");
            CleanChattingUI.d(this.lgN);
            ag.y(new 1(this));
            Cursor asR = b.asG().asH().asR();
            if (asR != null) {
                while (asR.moveToNext()) {
                    c cVar = new c();
                    cVar.username = asR.getString(0);
                    cVar.size = asR.getLong(1);
                    CleanChattingUI.f(this.lgN).add(cVar);
                }
            }
            ag.y(new 2(this));
        }
    }
}
