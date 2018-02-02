package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.chatting.b.e.11;

class e$11$1 implements OnCancelListener {
    final /* synthetic */ jw yzh;
    final /* synthetic */ 11 yzi;

    e$11$1(11 11, jw jwVar) {
        this.yzi = 11;
        this.yzh = jwVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.yzh.fAV.fAJ = true;
        a.xef.m(this.yzh);
    }
}
