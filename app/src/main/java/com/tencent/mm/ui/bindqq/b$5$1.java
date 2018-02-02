package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.ui.bindqq.b.5;
import com.tencent.mm.z.ar;

class b$5$1 implements OnCancelListener {
    final /* synthetic */ al qiJ;
    final /* synthetic */ 5 ymN;

    b$5$1(5 5, al alVar) {
        this.ymN = 5;
        this.qiJ = alVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.ymN.ymM.onDetach();
        ar.CG().c(this.qiJ);
    }
}
