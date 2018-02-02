package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.af.a;
import com.tencent.mm.ui.bindqq.VerifyQQUI.2;
import com.tencent.mm.z.ar;

class VerifyQQUI$2$1 implements OnCancelListener {
    final /* synthetic */ a ymY;
    final /* synthetic */ 2 ymZ;

    VerifyQQUI$2$1(2 2, a aVar) {
        this.ymZ = 2;
        this.ymY = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.ymY);
    }
}
