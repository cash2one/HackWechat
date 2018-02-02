package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.ui.chatting.viewitems.q.a.2;
import com.tencent.mm.z.ar;

class q$a$2$2 implements OnCancelListener {
    final /* synthetic */ o yLN;
    final /* synthetic */ 2 yLX;

    q$a$2$2(2 2, o oVar) {
        this.yLX = 2;
        this.yLN = oVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.yLN);
    }
}
