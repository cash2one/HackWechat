package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.ui.base.b;

class t$6 implements OnClickListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ Intent xKb;

    t$6(Intent intent, Activity activity) {
        this.xKb = intent;
        this.icz = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.xKb != null) {
            this.icz.finish();
            this.icz.startActivity(this.xKb);
            b.B(this.icz, this.xKb);
            d.br(this.icz);
        }
    }
}
