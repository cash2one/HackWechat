package com.tencent.mm.plugin.profile.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class a$1 implements a {
    final /* synthetic */ a plr;

    a$1(a aVar) {
        this.plr = aVar;
    }

    public final boolean uF() {
        if (!this.plr.fAF.isFinishing()) {
            a aVar = this.plr;
            Context context = this.plr.fAF;
            this.plr.fAF.getString(R.l.dGO);
            aVar.mIl = h.a(context, this.plr.fAF.getString(R.l.dHc), true, new OnCancelListener(this) {
                final /* synthetic */ a$1 pls;

                {
                    this.pls = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ar.CG().c(this.pls.plr.plp);
                    this.pls.plr.mIl = null;
                }
            });
        }
        return false;
    }
}
