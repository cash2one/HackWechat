package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class ad$5 implements Runnable {
    final /* synthetic */ ad ruF;

    ad$5(ad adVar) {
        this.ruF = adVar;
    }

    public final void run() {
        x.i("MicroMsg.SightWidget", "showProgress");
        ad adVar = this.ruF;
        Context context = this.ruF.fmM;
        this.ruF.fmM.getString(j.dGO);
        adVar.iln = h.a(context, this.ruF.fmM.getString(j.qMh), false, new OnCancelListener(this) {
            final /* synthetic */ ad$5 ruG;

            {
                this.ruG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.ruG.ruF.ruB = null;
                this.ruG.ruF.ruw = false;
                ag.K(this.ruG.ruF.ruD);
            }
        });
    }
}
