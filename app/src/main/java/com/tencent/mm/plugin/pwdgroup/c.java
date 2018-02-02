package com.tencent.mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.ad.n;
import com.tencent.mm.by.h.d;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c implements ap {
    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        a.plt = new j.a(this) {
            private Bitmap feJ = null;
            private f<String, WeakReference<Bitmap>> plu;
            final /* synthetic */ c plv;

            {
                this.plv = r5;
                try {
                    this.feJ = b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", e, "", new Object[0]);
                }
                this.plu = new f(15);
            }

            public final void a(j jVar) {
                if (jVar instanceof com.tencent.mm.ad.d.a) {
                    n.Jz().a((com.tencent.mm.ad.d.a) jVar);
                }
            }

            public final Bitmap cm(String str) {
                WeakReference weakReference = (WeakReference) this.plu.get(str);
                if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled() && weakReference.get() == this.feJ) {
                    return (Bitmap) weakReference.get();
                }
                Bitmap a = com.tencent.mm.ad.b.a(str, false, -1);
                if (a == null || a.isRecycled()) {
                    return this.feJ;
                }
                this.plu.l(str, new WeakReference(a));
                return a;
            }

            public final Bitmap tJ() {
                return this.feJ;
            }

            public final Bitmap cn(String str) {
                return null;
            }

            public final Bitmap b(String str, int i, int i2, int i3) {
                return null;
            }
        };
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
