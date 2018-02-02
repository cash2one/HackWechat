package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aa$2 implements OnClickListener {
    final /* synthetic */ aa yCl;
    final /* synthetic */ String yCm;

    aa$2(aa aaVar, String str) {
        this.yCl = aaVar;
        this.yCm = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yCl.Zj(this.yCm);
    }
}
