package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.ui.chatting.viewitems.q.1.2;
import com.tencent.mm.z.ar;

class q$1$2$4 implements OnCancelListener {
    final /* synthetic */ 2 yLL;
    final /* synthetic */ o yLN;

    q$1$2$4(2 2, o oVar) {
        this.yLL = 2;
        this.yLN = oVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.yLN);
    }
}
