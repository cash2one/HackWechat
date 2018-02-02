package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ag.a.x;
import com.tencent.mm.z.ar;

class c$7 implements OnCancelListener {
    final /* synthetic */ x yoL;
    final /* synthetic */ c yyQ;

    c$7(c cVar, x xVar) {
        this.yyQ = cVar;
        this.yoL = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.yoL);
    }
}
