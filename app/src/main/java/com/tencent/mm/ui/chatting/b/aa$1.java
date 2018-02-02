package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class aa$1 implements OnClickListener {
    final /* synthetic */ Runnable yCk;
    final /* synthetic */ aa yCl;

    public aa$1(aa aaVar, Runnable runnable) {
        this.yCl = aaVar;
        this.yCk = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yCk.run();
        b epVar = new ep();
        epVar.ftg.username = this.yCl.fhr.csi().field_username;
        a.xef.m(epVar);
    }
}
