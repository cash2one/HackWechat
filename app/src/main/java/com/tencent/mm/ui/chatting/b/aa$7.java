package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aa$7 implements OnClickListener {
    final /* synthetic */ aa yCl;
    final /* synthetic */ boolean yCn;

    aa$7(aa aaVar, boolean z) {
        this.yCl = aaVar;
        this.yCn = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yCl.Zj(this.yCn ? "fromBanner" : "fromPluginTalk");
    }
}
