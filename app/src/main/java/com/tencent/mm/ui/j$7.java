package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.b.a.a;

class j$7 implements OnClickListener {
    final /* synthetic */ int val$id;
    final /* synthetic */ j xFL;
    final /* synthetic */ a xFQ;

    j$7(j jVar, int i, a aVar) {
        this.xFL = jVar;
        this.val$id = i;
        this.xFQ = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(this.xFL, this.val$id, this.xFQ.actionType, this.xFQ.id, this.xFQ.vCR);
        dialogInterface.dismiss();
    }
}
