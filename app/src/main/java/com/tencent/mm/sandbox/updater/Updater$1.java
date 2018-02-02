package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.z.ar;

class Updater$1 implements OnCancelListener {
    final /* synthetic */ Updater xdn;
    final /* synthetic */ OnCancelListener xdo;

    Updater$1(Updater updater, OnCancelListener onCancelListener) {
        this.xdn = updater;
        this.xdo = onCancelListener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.getNotification().cancel(99);
        g.pQN.a(405, 47, 1, true);
        Updater.CY(2);
        this.xdn.onStop();
        if (!Updater.a(this.xdn) && this.xdo != null) {
            this.xdo.onCancel(dialogInterface);
        }
    }
}
