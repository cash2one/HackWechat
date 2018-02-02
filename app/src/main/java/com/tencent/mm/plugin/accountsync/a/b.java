package com.tencent.mm.plugin.accountsync.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;

public final class b implements e, f {
    public Context context;
    public k frb;
    private af handler = new af(Looper.getMainLooper());
    public a ikC;
    public r tipDialog;

    public b(Context context, a aVar) {
        this.context = context;
        this.ikC = aVar;
    }

    public final void a(int i, int i2, k kVar) {
        this.handler.post(new 2(this, i2 != 0 ? (int) ((((long) i) * 100) / ((long) i2)) : 0));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == v.CTRL_INDEX) {
            ar.CG().b(v.CTRL_INDEX, this);
        } else if (kVar.getType() == 138) {
            ar.CG().b(138, this);
        }
        if (i2 == 0 && i == 0) {
            this.ikC.Xo();
        } else {
            x.e("MicroMsg.DoInit", "do init failed, err=" + i + "," + i2);
            this.ikC.Xo();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
    }
}
