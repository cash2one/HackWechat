package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.b;

class t$2 implements OnCancelListener {
    final /* synthetic */ Activity oZ;
    final /* synthetic */ String val$url;
    final /* synthetic */ Intent xKb;

    t$2(String str, Activity activity, Intent intent) {
        this.val$url = str;
        this.oZ = activity;
        this.xKb = intent;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.pQN.a(322, 24, 1, true);
        g gVar = g.pQN;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(4024);
        objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bh.ov(this.val$url)), this.val$url});
        gVar.h(11098, objArr);
        this.oZ.startActivity(this.xKb);
        b.B(this.oZ, this.xKb);
        d.br(this.oZ);
    }
}
