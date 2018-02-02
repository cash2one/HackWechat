package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.ui.chatting.viewitems.ag.c;

class ag$c$1 implements OnClickListener {
    final /* synthetic */ r yFU;
    final /* synthetic */ c yNt;

    ag$c$1(c cVar, r rVar) {
        this.yNt = cVar;
        this.yFU = rVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.Zw(this.yFU.getFileName());
    }
}
