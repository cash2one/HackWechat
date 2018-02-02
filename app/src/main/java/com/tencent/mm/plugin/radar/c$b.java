package com.tencent.mm.plugin.radar;

import android.content.Context;
import android.graphics.Bitmap;
import b.c.b.e;
import b.i;
import com.tencent.mm.a.f;
import com.tencent.mm.ad.n;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.lang.ref.WeakReference;

public final class c$b implements a {
    private Bitmap feJ;
    private final f<String, WeakReference<Bitmap>> plu = new f(15);
    private Bitmap pwu;

    c$b() {
        try {
            Context context = ac.getContext();
            e.h(context, "MMApplicationContext.getContext()");
            this.feJ = b.a(context.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
            Bitmap bitmap = this.feJ;
            Bitmap bitmap2 = this.feJ;
            if (bitmap2 == null) {
                e.cJy();
            }
            this.pwu = d.a(bitmap, false, (float) (bitmap2.getWidth() / 2));
        } catch (IOException e) {
            c.a aVar = c.pwt;
            x.printErrStackTrace(c.access$getTAG$cp(), e, "", new Object[0]);
        }
    }

    public final void a(j jVar) {
        e.i(jVar, "drawable");
        if (jVar instanceof com.tencent.mm.ad.d.a) {
            n.Jz().a((com.tencent.mm.ad.d.a) jVar);
        }
    }

    public final Bitmap cm(String str) {
        e.i(str, "tag");
        WeakReference weakReference = (WeakReference) this.plu.get(str);
        if (!(weakReference == null || weakReference.get() == null)) {
            Object obj = weakReference.get();
            if (obj == null) {
                throw new i("null cannot be cast to non-null type android.graphics.Bitmap");
            } else if (!((Bitmap) obj).isRecycled() && (e.h((Bitmap) weakReference.get(), this.feJ) ^ 1) == 0) {
                return (Bitmap) weakReference.get();
            }
        }
        Bitmap iV = com.tencent.mm.ad.b.iV(str);
        if (iV == null || iV.isRecycled()) {
            return this.pwu;
        }
        iV = d.a(iV, false, (float) (iV.getWidth() / 2));
        this.plu.l(str, new WeakReference(iV));
        return iV;
    }

    public final Bitmap tJ() {
        return this.feJ;
    }

    public final Bitmap cn(String str) {
        e.i(str, "tag");
        return null;
    }

    public final Bitmap b(String str, int i, int i2, int i3) {
        e.i(str, "tag");
        return null;
    }
}
