package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.chatting.c.1;
import com.tencent.mm.z.ar;

class c$1$1 implements OnCancelListener {
    final /* synthetic */ 1 yqg;

    c$1$1(1 1) {
        this.yqg = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().b(1030, this.yqg.yqf);
    }
}
