package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.bj.a.g;
import com.tencent.mm.bo.b;
import com.tencent.mm.sdk.platformtools.d;

public final class c extends a {
    private Bitmap zFO;
    private Bitmap zFP;

    protected final void cAz() {
        super.cAz();
        this.zFO = d.u(getResources().getDrawable(g.vbM));
        this.zFP = d.u(getResources().getDrawable(g.vbL));
    }

    protected final Bitmap a(com.tencent.mm.api.d dVar, boolean z) {
        if (dVar == com.tencent.mm.api.d.fdA) {
            return z ? this.zFP : this.zFO;
        } else {
            return null;
        }
    }

    public c(Context context, b bVar) {
        super(context, bVar);
    }

    protected final boolean Ht(int i) {
        boolean Ht = super.Ht(i);
        switch (1.vAh[Hs(i).ordinal()]) {
            case 1:
                return false;
            default:
                return Ht;
        }
    }
}
