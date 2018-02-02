package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.z.ar;

class BindMContactIntroUI$27 implements OnCancelListener {
    final /* synthetic */ BindMContactIntroUI ylI;
    final /* synthetic */ t ylJ;

    BindMContactIntroUI$27(BindMContactIntroUI bindMContactIntroUI, t tVar) {
        this.ylI = bindMContactIntroUI;
        this.ylJ = tVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.ylJ);
    }
}
