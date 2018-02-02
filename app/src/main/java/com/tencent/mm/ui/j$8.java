package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.b.a.a;

class j$8 implements OnClickListener {
    final /* synthetic */ int val$id;
    final /* synthetic */ j xFL;
    final /* synthetic */ a xFR;

    j$8(j jVar, int i, a aVar) {
        this.xFL = jVar;
        this.val$id = i;
        this.xFR = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(this.xFL, this.val$id, this.xFR.actionType, this.xFR.id, this.xFR.vCR);
        dialogInterface.dismiss();
    }
}
