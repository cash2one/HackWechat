package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.g.a.y;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.z.ar;

class t$9 implements OnClickListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ Intent xKb;

    t$9(Intent intent, Activity activity) {
        this.xKb = intent;
        this.icz = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.xKb != null) {
            if (!(this.icz instanceof LauncherUI)) {
                this.icz.finish();
            }
            ar.hold();
            this.icz.startActivity(this.xKb);
            b.B(this.icz, this.xKb);
            d.br(this.icz);
            com.tencent.mm.sdk.b.b yVar = new y();
            yVar.fnQ.fnR = true;
            a.xef.m(yVar);
        }
    }
}
