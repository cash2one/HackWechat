package com.tencent.mm.pluginsdk.model.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.g.a;

class g$5 implements OnClickListener {
    final /* synthetic */ a nbx;
    final /* synthetic */ String uN;
    final /* synthetic */ String vek;
    final /* synthetic */ String vel;

    g$5(String str, String str2, String str3, a aVar) {
        this.uN = str;
        this.vek = str2;
        this.vel = str3;
        this.nbx = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14102, new Object[]{Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), this.uN, this.vek, this.vel});
        if (this.nbx != null) {
            this.nbx.cG(false);
        }
    }
}
