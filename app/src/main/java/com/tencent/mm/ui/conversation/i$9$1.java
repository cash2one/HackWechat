package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.ui.conversation.i.9;
import com.tencent.mm.z.ar;

class i$9$1 implements OnCancelListener {
    final /* synthetic */ 9 yZD;

    i$9$1(9 9) {
        this.yZD = 9;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(i.g(this.yZD.yZy));
        if (n.qQz != null) {
            n.qQz.buf();
        }
    }
}
