package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.boo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

class d$4 implements a {
    final /* synthetic */ Context val$context;
    final /* synthetic */ ProgressDialog vcj;

    d$4(ProgressDialog progressDialog, Context context) {
        this.vcj = progressDialog;
        this.val$context = context;
    }

    public final void a(int i, int i2, String str, k kVar, boolean z) {
        x.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z)});
        if (this.vcj != null && this.vcj.isShowing()) {
            this.vcj.dismiss();
        }
        if (kVar != null && i != 0 && i2 != 0 && (kVar instanceof ak)) {
            boo Sq = ((ak) kVar).Sq();
            if (Sq != null && this.val$context != null) {
                u.makeText(this.val$context, this.val$context.getString(R.l.dGO) + " : " + bh.ou(Sq.wQX), 0).show();
            }
        }
    }
}
