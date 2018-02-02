package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class g$2 implements OnClickListener {
    final /* synthetic */ Runnable lKM;
    final /* synthetic */ String uN;
    final /* synthetic */ String vek;
    final /* synthetic */ String vel;

    g$2(String str, String str2, String str3, Runnable runnable) {
        this.uN = str;
        this.vek = str2;
        this.vel = str3;
        this.lKM = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14102, new Object[]{Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.uN, this.vek, this.vel});
        this.lKM.run();
    }
}
