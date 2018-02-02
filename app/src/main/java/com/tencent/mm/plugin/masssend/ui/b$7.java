package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.z.ar;

class b$7 implements OnCancelListener {
    final /* synthetic */ b onk;
    final /* synthetic */ f onl;

    b$7(b bVar, f fVar) {
        this.onk = bVar;
        this.onl = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.onl);
        if (this.onk.tipDialog != null) {
            this.onk.tipDialog.dismiss();
            this.onk.tipDialog = null;
        }
    }
}
