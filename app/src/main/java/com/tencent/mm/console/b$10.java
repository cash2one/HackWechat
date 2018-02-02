package com.tencent.mm.console;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ah;
import com.tencent.mm.z.ar;

class b$10 implements ah {
    final /* synthetic */ ProgressDialog gIB;
    final /* synthetic */ Context val$context;

    b$10(ProgressDialog progressDialog, Context context) {
        this.gIB = progressDialog;
        this.val$context = context;
    }

    public final void fW(int i) {
        x.i("MicroMsg.CommandProcessor", "ipxx progress:%d", new Object[]{Integer.valueOf(i)});
        if (i < 0) {
            ar.a(null);
            this.gIB.dismiss();
            h.h(this.val$context, R.l.eSf, R.l.dGO);
        } else if (i >= 100) {
            ar.a(null);
            this.gIB.dismiss();
            h.h(this.val$context, R.l.eSj, R.l.dGO);
        } else {
            this.gIB.setMessage(this.val$context.getString(R.l.eSg) + i + "%");
        }
    }
}
