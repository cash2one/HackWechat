package com.tencent.mm.ui.bindlinkedin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.at.b;
import com.tencent.mm.ui.bindlinkedin.BindLinkedInUI.8.1;
import com.tencent.mm.z.ar;

class BindLinkedInUI$8$1$1 implements OnCancelListener {
    final /* synthetic */ b yly;
    final /* synthetic */ 1 ylz;

    BindLinkedInUI$8$1$1(1 1, b bVar) {
        this.ylz = 1;
        this.yly = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.yly);
    }
}
