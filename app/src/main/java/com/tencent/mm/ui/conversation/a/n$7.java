package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class n$7 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ n zby;

    n$7(n nVar, int i) {
        this.zby = nVar;
        this.iGh = i;
    }

    public final void onClick(View view) {
        try {
            an.startSettingItent((Context) this.zby.voC.get(), this.iGh);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
        }
    }
}
