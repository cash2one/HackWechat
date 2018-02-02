package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.af.a;
import com.tencent.mm.ui.bindqq.VerifyQQUI.4;
import com.tencent.mm.z.ar;

class VerifyQQUI$4$1 implements OnCancelListener {
    final /* synthetic */ a ymY;
    final /* synthetic */ 4 yna;

    VerifyQQUI$4$1(4 4, a aVar) {
        this.yna = 4;
        this.ymY = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.ymY);
    }
}
