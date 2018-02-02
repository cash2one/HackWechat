package com.tencent.mm.ui.bindlinkedin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.at.a;
import com.tencent.mm.z.ar;

class BindLinkedInUI$11 implements OnCancelListener {
    final /* synthetic */ a ylA;
    final /* synthetic */ BindLinkedInUI ylv;

    BindLinkedInUI$11(BindLinkedInUI bindLinkedInUI, a aVar) {
        this.ylv = bindLinkedInUI;
        this.ylA = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.ylA);
    }
}
