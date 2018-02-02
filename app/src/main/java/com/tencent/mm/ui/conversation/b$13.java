package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;

class b$13 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ Context val$context;
    final /* synthetic */ PBool yWn;
    final /* synthetic */ boolean yWq;
    final /* synthetic */ boolean yWr;

    b$13(PBool pBool, Context context, boolean z, String str, boolean z2) {
        this.yWn = pBool;
        this.val$context = context;
        this.yWq = z;
        this.gIx = str;
        this.yWr = z2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yWn.value = true;
        b.a(this.val$context, this.yWq, this.gIx);
        if (this.yWr) {
            g.pQN.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(4), this.gIx});
        }
    }
}
