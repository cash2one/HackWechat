package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.n;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.ac;

final class b implements a {
    private Bitmap feJ;
    d feK;

    public b() {
        this.feJ = null;
        this.feJ = com.tencent.mm.compatible.f.a.decodeResource(ac.getContext().getResources(), R.k.bBB);
    }

    public final void a(j jVar) {
        if (jVar instanceof d.a) {
            n.Jz().a((d.a) jVar);
        }
    }

    public final Bitmap cm(String str) {
        return com.tencent.mm.ad.b.a(str, false, -1);
    }

    public final Bitmap tJ() {
        return this.feJ;
    }

    public final Bitmap cn(String str) {
        if (this.feK == null) {
            this.feK = n.Jz();
        }
        return d.jc(str);
    }

    public final Bitmap b(String str, int i, int i2, int i3) {
        return com.tencent.mm.ad.b.c(str, i, i2, i3);
    }
}
