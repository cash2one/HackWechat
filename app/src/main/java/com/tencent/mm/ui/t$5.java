package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.b;

class t$5 implements OnCancelListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ Intent xKb = null;

    t$5(Intent intent, Activity activity) {
        this.icz = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.pQN.a(405, 39, 1, true);
        if (this.xKb != null) {
            this.icz.finish();
            this.icz.startActivity(this.xKb);
            b.B(this.icz, this.xKb);
        }
    }
}
