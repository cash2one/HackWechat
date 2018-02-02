package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class aa$10 implements OnClickListener {
    final /* synthetic */ aa yCl;

    aa$10(aa aaVar) {
        this.yCl = aaVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b riVar = new ri();
        riVar.fJc.fJf = true;
        a.xef.m(riVar);
        this.yCl.Zk(this.yCl.fhr.csi().field_username);
    }
}
