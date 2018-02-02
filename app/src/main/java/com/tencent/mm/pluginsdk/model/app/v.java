package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

public final class v implements t {
    k frb;
    public Context mContext;
    public r tipDialog;
    public a veB;

    public v(Context context, a aVar) {
        this.mContext = context;
        this.veB = aVar;
    }

    public final void a(int i, int i2, String str, w wVar) {
        x.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        an.aRi().b(7, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.veB != null) {
            this.veB.bFx();
        }
        g.bYG();
    }
}
