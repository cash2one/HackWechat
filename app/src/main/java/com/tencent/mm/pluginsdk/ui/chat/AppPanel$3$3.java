package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.3;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class AppPanel$3$3 implements OnClickListener {
    final /* synthetic */ 3 vpr;

    AppPanel$3$3(3 3) {
        this.vpr = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b riVar = new ri();
        riVar.fJc.fJf = true;
        a.xef.m(riVar);
        AppPanel.k(this.vpr.vpq).aYO();
        dialogInterface.dismiss();
    }
}
