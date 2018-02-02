package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.chatting.viewitems.al.h;

class al$h$1 implements OnClickListener {
    final /* synthetic */ ar yOm;
    final /* synthetic */ h yOn;

    al$h$1(h hVar, ar arVar) {
        this.yOn = hVar;
        this.yOm = arVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b riVar = new ri();
        riVar.fJc.fJf = true;
        a.xef.m(riVar);
        h.a(this.yOn, this.yOm);
        dialogInterface.dismiss();
    }
}
