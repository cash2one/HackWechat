package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class p$6 implements Runnable {
    final /* synthetic */ Activity oZ;
    final /* synthetic */ p pYq;

    p$6(p pVar, Activity activity) {
        this.pYq = pVar;
        this.oZ = activity;
    }

    public final void run() {
        p pVar = this.pYq;
        Context context = this.oZ;
        this.oZ.getString(R.l.dGO);
        pVar.iln = h.a(context, this.oZ.getString(R.l.eBz), true, new OnCancelListener(this) {
            final /* synthetic */ p$6 pYs;

            {
                this.pYs = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.pYs.pYq.pYh = false;
                this.pYs.pYq.pYg.set(false);
                this.pYs.pYq.pYi = false;
            }
        });
    }
}
