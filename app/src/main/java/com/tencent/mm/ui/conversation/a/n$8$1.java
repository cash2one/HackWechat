package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.n.8;

class n$8$1 implements OnClickListener {
    final /* synthetic */ 8 zbA;

    n$8$1(8 8) {
        this.zbA = 8;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.zbA.zby.kpZ.setVisibility(8);
            this.zbA.zby.zbx = true;
            an.startSettingItent((Context) this.zbA.zby.voC.get(), this.zbA.iGh);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetWarnView", e, "", new Object[0]);
        }
    }
}
