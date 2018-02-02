package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.b.a.a;

class j$9 implements OnClickListener {
    final /* synthetic */ int val$id;
    final /* synthetic */ j xFL;
    final /* synthetic */ a xFS;

    j$9(j jVar, int i, a aVar) {
        this.xFL = jVar;
        this.val$id = i;
        this.xFS = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(this.xFL, this.val$id, this.xFS.actionType, this.xFS.id, this.xFS.vCR);
        dialogInterface.dismiss();
    }
}
