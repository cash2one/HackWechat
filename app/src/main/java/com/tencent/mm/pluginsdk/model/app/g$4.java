package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.g.a;

class g$4 implements OnClickListener {
    final /* synthetic */ a nbx;
    final /* synthetic */ String uN;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ String vek;
    final /* synthetic */ String vel;

    g$4(Context context, Intent intent, String str, String str2, String str3, a aVar) {
        this.val$context = context;
        this.val$intent = intent;
        this.uN = str;
        this.vek = str2;
        this.vel = str3;
        this.nbx = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.val$context.startActivity(this.val$intent);
        g.pQN.h(14102, new Object[]{Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(1), this.uN, this.vek, this.vel});
        if (this.nbx != null) {
            this.nbx.cG(true);
        }
    }
}
