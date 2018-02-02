package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.wallet_core.ui.g;

public final class a {
    private Dialog ilS = null;
    private Context mContext;
    a sEH = null;

    public a(Context context, a aVar) {
        this.mContext = context;
        this.sEH = aVar;
    }

    public final void release() {
        this.sEH = null;
        this.mContext = null;
    }

    public final void a(boolean z, int i, String str) {
        b gvVar = new gv();
        gvVar.fwV = null;
        gvVar.fwU.fwW = z;
        if (z && (this.ilS == null || !(this.ilS == null || this.ilS.isShowing()))) {
            if (this.ilS != null) {
                this.ilS.dismiss();
            }
            this.ilS = g.a(this.mContext, false, new 2(this));
        }
        gvVar.fwU.fwX = i;
        gvVar.fwU.fwY = str;
        gvVar.fqI = new 1(this, gvVar);
        com.tencent.mm.sdk.b.a.xef.a(gvVar, Looper.getMainLooper());
    }

    public final void bJV() {
        if (this.ilS != null) {
            this.ilS.dismiss();
            this.ilS = null;
        }
    }
}
